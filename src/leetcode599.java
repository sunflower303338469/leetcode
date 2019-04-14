import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/2/14.
 */
public class leetcode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i =0; i<list1.length; i++){
            indexMap.put(list1[i], i);
        }
        int maxIndex = 3000;
        List<String> ans = new ArrayList<>();
        for (int i =0; i<list2.length; i++){
            if (indexMap.containsKey(list2[i])){
                if (i + indexMap.get(list2[i]) < maxIndex){
                    ans.clear();
                    maxIndex = i + indexMap.get(list2[i]);
                    ans.add(list2[i]);
                } else if (i + indexMap.get(list2[i]) == maxIndex){
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
