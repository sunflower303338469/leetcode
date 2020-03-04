import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/2/12.
 */
public class leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i =0;i<candidates.length;i++){
            if (target>candidates[i]){
                int[] n = new int[candidates.length-i];
                for (int j=i;j<candidates.length;j++){
                    n[j-i] = candidates[j];
                }
                List<List<Integer>> aList = combinationSum(n, target-candidates[i]);
                for (List<Integer> tempList:aList){
                    tempList.add(candidates[i]);
                }
                ans.addAll(aList);
            } else if (target == candidates[i]){
                List<Integer> newAns = new ArrayList<>();
                newAns.add(candidates[i]);
                ans.add(newAns);
            }
        }
        return ans;
    }
}
