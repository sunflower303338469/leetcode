import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/7/7.
 */
public class leetcode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i=0;i<dominoes.length;i++){
            List<Integer> newList = new ArrayList<>();
            for (int j=0;j<dominoes[i].length;j++){
                newList.add(dominoes[i][j]);
            }
            newList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            if (map.containsKey(newList)){
                ans = ans + map.get(newList);
                map.put(newList, map.get(newList)+1);
            } else {
                map.put(newList, 1);
            }
        }
        return ans;
    }
}
