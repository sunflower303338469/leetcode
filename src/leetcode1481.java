import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/8/4.
 */
public class leetcode1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer count = countMap.getOrDefault(arr[i], 0);
            count++;
            countMap.put(arr[i], count);
        }
        List<Integer> countList = countMap.values().stream().collect(Collectors.toList());
        int ans = countList.size();
        countList.sort(Comparator.naturalOrder());
        for (Integer count: countList){
            if (k>=count){
                k = k-count;
                ans--;
            }
        }
        return ans;
    }
}
