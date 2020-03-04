import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/2/28.
 */
public class leetcode851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] inCounts = new int[quiet.length];
        boolean[] visit = new boolean[quiet.length];
        int[] ans = new int[quiet.length];
        Map<Integer, List<Integer>> connectMap = new HashMap<>();
        for (int i =0;i<quiet.length;i++){
            ans[i] = i;
        }
        for (int i = 0; i < richer.length; i++) {
            int x = richer[i][0];
            int y = richer[i][1];
            inCounts[y]++;
            List<Integer> connect = connectMap.getOrDefault(x, new ArrayList<>());
            connect.add(y);
            connectMap.put(x, connect);
        }
        for (int i =0;i<quiet.length;i++){
            Integer nowNode = null;
            for (int node = 0;node<quiet.length;node++){
                if ((!visit[node]) && (inCounts[node]==0)){
                    nowNode = node;
                    break;
                }
            }
            if (nowNode==null){
                break;
            }
            visit[nowNode] = true;
            List<Integer> connect = connectMap.getOrDefault(nowNode, new ArrayList<>());
            for (Integer nextNode:connect){
                if (quiet[nowNode]<quiet[nextNode]){
                    quiet[nextNode] = quiet[nowNode];
                    ans[nextNode] = ans[nowNode];
                }
                inCounts[nextNode]--;
            }
        }
        return ans;
    }
}
