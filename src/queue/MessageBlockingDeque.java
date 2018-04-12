package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class MessageBlockingDeque<T> {
    //消息阻塞式队列  范式
    private BlockingQueue<T> m_queue = null;

    /**
     *  初始化队列容量
     *  @param  n 队列数
     * */
    public MessageBlockingDeque(Integer n){
        m_queue = new LinkedBlockingDeque<T>(n);
    }

    /**
     *  获取当前队列数
     *
     * */
    public int getQueueSize(){
        return m_queue.size();
    }

    /**
     *  清空当前队列
     * */
    public void clearQueue(){
        m_queue.clear();
    }

    /**
     *  得到当前队列头项目
     * */
    public T getObject(){
        return m_queue.poll();
    }

    /**
     *  得到当前队列头项目
     *  @param timeout
     *            超时时间
     *  @return 当前队列头项目
     * */
    public T getObject(long timeout) throws InterruptedException {
        return m_queue.poll(timeout,TimeUnit.MILLISECONDS);
    }

    /**
     * 放入队列尾元素
     *
     * @return 成功为true,失败为false,失败一般是队列满
     */
    public boolean put(T item){
        return m_queue.offer(item);
    }

    /**
     * 放入队列尾元素
     *
     * @param item
     *            超时时间
     * @return 成功为true,失败为false,失败一般是队列满
     */
    public boolean put(T item,long timeout) throws InterruptedException {
        return m_queue.offer(item,timeout,TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        MessageBlockingDeque<String> msg = new MessageBlockingDeque<String>(4);
        msg.put("aaaaaa");
        msg.put("bbbbbb");
        msg.put("cccccc");
        msg.put("dddddd");
        msg.put("eeeeee");

        while (msg.getQueueSize() > 0) {
            System.out.println(msg.getObject());
        }
    }

}
