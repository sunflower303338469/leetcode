import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/4/10.
 */
public class leetcode1329 {
    public int[][] diagonalSort(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        Map<Integer, List<Integer>> map =new HashMap<>();
        for (int i =0;i<mat.length;i++){
            for (int j =0;j<mat[0].length;j++){
                List<Integer> list = map.getOrDefault(i-j, new ArrayList<>());
                list.add(mat[i][j]);
                map.put(i-j,list);
            }
        }
        for (Integer key:map.keySet()){
            List<Integer> list = map.get(key);
            list.sort(Comparator.naturalOrder());
            int l =0;
            for (int i =0;i<mat.length;i++){
                int j = i-key;
                if ((j>=0) && (j<mat[0].length)){
                    ans[i][j] = list.get(l);
                    l++;
                }
            }
        }
        return ans;
    }
}
