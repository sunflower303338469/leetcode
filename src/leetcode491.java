import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/10/12.
 */
public class leetcode491 {

    Set<List<Integer>> ans = new HashSet<>();
    List<Integer> nowList=  new ArrayList<>();
    int[] numList;

    public List<List<Integer>> findSubsequences(int[] nums) {
        numList = nums;
        dfs(0);

        return ans.stream().collect(Collectors.toList());
    }

    private void dfs(Integer index){
        if (index>=numList.length){
            List<Integer> temp  =new ArrayList<>();
            temp.addAll(nowList);
            if (temp.size()>=2){
                ans.add(temp);
            }
            return;
        }
        if (nowList.isEmpty() || nowList.get(nowList.size()-1)<=numList[index]){
            nowList.add(numList[index]);
            dfs(index+1);
            nowList.remove(nowList.size()-1);
        }
        dfs(index+1);
    }
}
