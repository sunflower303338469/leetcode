import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/11.
 */
public class leetcode216 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> nowList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        dfs(k,n,1);
        return ans;
    }

    private void dfs(int k, int n, int start){
        if (k*start>n){
            return;
        }
        if (k==1){
            if (n>9){
                return;
            }
            nowList.add(n);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(nowList);
            ans.add(temp);
            nowList.remove(nowList.size()-1);
            return;
        }
        for (int i =start;i<=9;i++){
            if (n>i){
                nowList.add(i);
                dfs(k-1,n-i,i+1);
                nowList.remove(nowList.size()-1);
            }
        }
    }
}
