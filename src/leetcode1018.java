import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/4/19.
 */
public class leetcode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int val = 0;
        for (int i=0;i<A.length;i++){
            val = val *2 + A[i];
            if (val%5 == 0){
                ans.add(true);
            } else {
                ans.add(false);
            }
            val = val % 10;
        }
        return ans;
    }
}
