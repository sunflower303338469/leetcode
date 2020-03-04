import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/2/28.
 */
public class leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        if (n<k){
            return new ArrayList<>();
        }
        if (k==1){
            List<List<Integer>> ans = new ArrayList<>();
            for (int i =1;i<=n;i++){
                List<Integer> a=  new ArrayList<>();
                a.add(i);
                ans.add(a);
            }
            return ans;
        }
        List<List<Integer>> ans = combine(n-1,k);
        List<List<Integer>> ans2 = combine(n-1,k-1);
        for (List<Integer> value: ans2){
            value.add(n);
            ans.add(value);
        }
        return ans;
    }
}
