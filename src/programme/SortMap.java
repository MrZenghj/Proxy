package programme;

import java.util.*;

public class SortMap {
    /**
     *  对map进行排序
     * */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "cc");
        map.put("b", "ca");
        map.put("g", "cb");
        map.put("sf", "cd");

        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(Map.Entry<String,String> mapping : list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
