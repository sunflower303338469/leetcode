import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/4/28.
 */
public class leetcode1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer> map =  new HashMap<>();
        Set<String> foodSet = new HashSet<>();
        Set<Integer> tableSet = new HashSet<>();
        for (int i =0;i<orders.size();i++){
            List<String> sList=  orders.get(i);
            String tableName=  sList.get(1);
            String foodName=  sList.get(2);
            Integer count  = map.getOrDefault(getKey(tableName,foodName),0);
            count++;
            map.put(getKey(tableName, foodName),count);
            foodSet.add(foodName);
            tableSet.add(Integer.valueOf(tableName));
        }
        List<String> foodList= foodSet.stream().collect(Collectors.toList());
        foodList.sort(Comparator.naturalOrder());
        List<Integer> tableList= tableSet.stream().collect(Collectors.toList());
        tableList.sort(Comparator.naturalOrder());
        List<List<String>> ans = new ArrayList<>();
        List<String> firstList = new ArrayList<>();
        firstList.add("Table");
        firstList.addAll(foodList);
        ans.add(firstList);
        for (int  i=0;i<tableList.size();i++){
            List<String> list = new ArrayList<>();
            list.add(tableList.get(i).toString());
            for (int j=0;j<foodList.size();j++){
                list.add(map.getOrDefault(getKey(tableList.get(i).toString(),foodList.get(j)),0).toString());
            }
            ans.add(list);
        }
        return ans;
    }

    private String getKey(String tableName, String foodName){
        return tableName+"+"+foodName;
    }
}
