import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanmao on 2020/9/3.
 */
public class leetcode51 {

    List<List<String>> ans = new ArrayList<>();
    List<Integer> now = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> cross1 = new HashSet<>();
    Set<Integer> cross2 = new HashSet<>();
    int nn;

    public List<List<String>> solveNQueens(int n) {
        nn=n;
        dfs(0);
        return ans;
    }

    private void dfs(int nowRow){
        if (nowRow==nn){
            List<String> tempAns = new ArrayList<>();
            for (int i =0;i<now.size();i++){
                StringBuilder tempRow = new StringBuilder();
                for (int j=0;j<nn;j++){
                    tempRow.append(".");
                }
                tempRow.setCharAt(now.get(i),'Q');
                tempAns.add(tempRow.toString());
            }
            ans.add(tempAns);
            return;
        }
        for (int i =0;i<nn;i++){
            if ((!col.contains(i)) && (!cross1.contains(nowRow-i)) && (!cross2.contains(nowRow+i))){
                col.add(i);
                cross1.add(nowRow-i);
                cross2.add(nowRow+i);
                now.add(i);
                dfs(nowRow+1);
                col.remove(i);
                cross1.remove(nowRow-i);
                cross2.remove(nowRow+i);
                now.remove(now.size()-1);
            }
        }
    }
}
