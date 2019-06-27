import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanmao on 2019/6/12.
 */
public class leetcode40 {

    Set<List<Integer>> ans = new HashSet<>();
    List<Integer> now = new ArrayList<>();
    List<Integer> can = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int i=0;i<candidates.length;i++) {
            can.add(candidates[i]);
        }
        can.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        recursion(0,target);
        List<List<Integer>> ansList = new ArrayList<>();
        ansList.addAll(ans);
        return ansList;
    }

    private void recursion(int index, int target){
        if (target == 0){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(now);
            ans.add(temp);
            return;
        }
        for (int i=index;i<can.size();i++){
            if (target-can.get(i)>=0){
                now.add(can.get(i));
                recursion(i+1, target-can.get(i));
                now.remove(can.get(i));
            }
        }
    }
}
