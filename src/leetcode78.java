import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanmao on 2019/11/11.
 */
public class leetcode78 {

    Set<List<Integer>> ans = new HashSet<>();
    List<Integer> now = new ArrayList<>();
    int[] numbers;

    public List<List<Integer>> subsets(int[] nums) {
        numbers= nums;
        getAns(0);
        return new ArrayList<>(ans);
    }

    private void getAns(int x){
        if (x>=numbers.length){
            List<Integer> newAns = new ArrayList<>(now);
            ans.add(newAns);
            return;
        }
        getAns(x+1);
        now.add(numbers[x]);
        getAns(x+1);
        now.remove(now.size()-1);
    }
}
