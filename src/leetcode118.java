import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/28.
 */
public class leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows==0){
            return ans;
        }
        ans.add(Collections.singletonList(1));
        for (int i=2;i<=numRows;i++){
            List<Integer> before = ans.get(ans.size()-1);
            List<Integer> after = new ArrayList<>();
            after.add(1);
            for (int j=0;j<before.size()-1;j++){
                after.add(before.get(j)+before.get(j+1));
            }
            after.add(1);
            ans.add(after);
        }
        return ans;
    }
}
