package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *      关于大数据批量插入（100万条数据）
 *        执行顺序： 1、每次执行执行一万条数据 提交
 *                   2、使用循环执行100次
 *                   3、每次提交 避免回滚出现大量回滚
 */
public class MysqlInsert {

    public static String url = "jdbc:mysql://localhost:3306/bigdata";

    /**
     *  第一种方式
     *      insert into tb (...) values(...),(...)...
     */
    public static void insert() {
        // 开时时间
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO tb_big_data (count, create_time, random) VALUES ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn  = DriverManager.getConnection(url,"root","123456");
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // Statement st = conn.createStatement();  conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement pst = conn.prepareStatement("");
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 100; i++) {
                // 第次提交步长
                for (int j = 1; j <= 10000; j++) {
                    // 构建sql后缀
                    suffix.append("(" + j * i + ", SYSDATE(), " + i * j
                            * Math.random() + "),");
                }
                // 构建完整sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行sql
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("cast : " + (end - begin) / 1000 + " ms");
    }

    /**
     *  第二种方式
     *      insert into tb (...) values (...);
     *      insert into tb (...) values (...);
     *      ...
     */
    public static void insertRelease() {
        Long begin = new Date().getTime();
        String sql = "INSERT INTO tb_big_data (count, create_time, random) VALUES (?, SYSDATE(), ?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn  = DriverManager.getConnection(url,"root","123456");
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i = 1; i <= 100; i++) {
                for (int k = 1; k <= 10000; k++) {
                    pst.setLong(1, k * i);
                    pst.setLong(2, k * i);
                    pst.addBatch();
                }
                pst.executeBatch();
                conn.commit();
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Long end = new Date().getTime();
        System.out.println("cast : " + (end - begin) / 1000 + " ms");
    }

   /* public static void insertBigData(SpringBatchHandler sbh) {
        Long begin = new Date().getTime();
        JdbcTemplate jdbcTemplate = sbh.getJdbcTemplate();
        final int count = 10000;
        String sql = "INSERT INTO tb_big_data (count, create_time, random) VALUES (?, SYSDATE(), ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            // 为prepared statement设置参数。这个方法将在整个过程中被调用的次数
            public void setValues(PreparedStatement pst, int i)
                    throws SQLException {
                pst.setLong(1, i);
                pst.setInt(2, i);
            }

            // 返回更新的结果集条数
            public int getBatchSize() {
                return count;
            }
        });
        Long end = new Date().getTime();
        System.out.println("cast : " + (end - begin) / 1000 + " ms");
    }*/

    public static void main(String[] args) {
        //  MysqlInsert.insert(); //执行时间 cast : 23 ms
        //  MysqlInsert.insertRelease(); //执行时间 cast : 157 ms
    }
}
