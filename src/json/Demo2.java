package json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo2 {
    public static void main(String[] args) {
        JSONObject jsonObject0 = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        //jsonObject0
        jsonObject0.put("name0", "Spring");
        jsonObject0.put("sex0", "man");
        System.out.println("jsonObject0:"+jsonObject0);
        //jsonObject1
        jsonObject1.put("name1", "summer");
        jsonObject1.put("sex1", "woman");
        System.out.println("jsonObject1"+jsonObject1);
        //jsonObject2
        jsonObject2.put("item0", jsonObject0);
        jsonObject2.put("item1", jsonObject1);
        System.out.println("jsonObject2"+jsonObject2);
        //jsonObject3
        jsonObject3.put("jo31", jsonObject2);
        jsonObject3.put("jo32", jsonObject3);
        System.out.println("jsonObject3"+jsonObject3);
        //往JSONArray中添加JSONObject对象。发现JSONArray跟JSONObject的区别就是JSONArray比JSONObject多中括号[]
        jsonArray.add(jsonObject1);
        System.out.println(jsonArray);
        jsonArray.add(jsonObject0);
        System.out.println(jsonArray); //添加多个数组
        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.element("weater", jsonArray);

        System.out.println("jsonObject4:"+jsonObject4);
    }
}
