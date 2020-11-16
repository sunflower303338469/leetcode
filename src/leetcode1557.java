import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/3.
 */
public class leetcode1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] rudu = new int[n];
        for (List<Integer> edge:edges){
            rudu[edge.get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i =0;i<n;i++){
            if (rudu[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}
