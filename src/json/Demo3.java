package json;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
/**
 *     map集合转json
 * */
public class Demo3 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("spring","spring1");
        map.put("summer", "summer1");
        map.put("autumn", "autumn1");
        JSONObject json = JSONObject.fromObject(map);
        //{"autumn":"autumn1","summer":"summer1","spring":"spring1"}
        System.out.println(json);
    }

}
