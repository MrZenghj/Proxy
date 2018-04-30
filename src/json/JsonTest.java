package json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *      所需要的jar  commons-beanutils-1.8.3.jar
 *                   commons-collections-3.2.1.jar
 *                   commons-lang-2.4.jar
 *                   commons-logging-1.1.3.jar
 *                   ezmorph-1.0.6.jar
 *                   json-lib-2.2.2-jdk15.jar
 *      java操作json格式的输出
 *          jsonObject 和 jsonArray
 * */
public class JsonTest {
    public static JSONObject getJson(){
        JSONObject object = new JSONObject();
        object.put("名字","snipe");
        object.put("爱好","看书，打游戏");
        object.put("年龄",22);
        return object;
    }


    public static void main(String[] args) {
        JSONObject object =JsonTest.getJson();
        System.out.println(object);
        System.out.println("数组？"+object.isArray()+";为空？"+ object.isEmpty()+";isNullObject?"+
                object.isNullObject()+";");
        object.put("address", "广州天河");
        System.out.println(object);

        // 返回一个JSONArray对象
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "Value0");
        jsonArray.add(1, "Value1");
        object.element("jsonArray", jsonArray);
        //在jsonObject后面住家一个jsonArray
        JSONArray array = object.getJSONArray("jsonArray");
        System.out.println("object"+ object);
        System.out.println("返回一个JSONArray对象：" + array);
        //根据key返回字符串
        String username = object.getString("名字");
        System.out.println("username:"+username);
        //字符串转换为jsonObject
        String temp = object.toString();
        System.out.println("temp" + temp);
        JSONObject obj = object.fromObject(temp);
        System.out.println("年龄:"+obj.get("年龄"));
    }

}
