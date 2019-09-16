import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2019/7/7.
 */
public class leetcode1129 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer,List<Integer>> redMap = new HashMap<>();
        Map<Integer,List<Integer>> buleMap = new HashMap<>();
        List<Integer> nodeList = new ArrayList<>();
        List<Integer> colorList = new ArrayList<>();
        List<Integer> longList=  new ArrayList<>();
        int[] ans = new int[n];
        int[][] ansc = new int[n][2];
        for (int i=1;i<ans.length;i++){
            ans[i] = -1;
            ansc[i][0] = -1;
            ansc[i][1] = -1;
        }
        for (int i=0;i<red_edges.length;i++){
            if (redMap.containsKey(red_edges[i][0])){
                List<Integer> temp = redMap.get(red_edges[i][0]);
                temp.add(red_edges[i][1]);
                redMap.put(red_edges[i][0], temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(red_edges[i][1]);
                redMap.put(red_edges[i][0], temp);
            }
            if ((red_edges[i][0] == 0) && (red_edges[i][1] != 0)){
                nodeList.add(red_edges[i][1]);
                colorList.add(0);
                longList.add(1);
                ans[red_edges[i][1]] = 1;
            }
        }
        for (int i=0;i<blue_edges.length;i++){
            if (buleMap.containsKey(blue_edges[i][0])){
                List<Integer> temp = buleMap.get(blue_edges[i][0]);
                temp.add(blue_edges[i][1]);
                buleMap.put(blue_edges[i][0], temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(blue_edges[i][1]);
                buleMap.put(blue_edges[i][0], temp);
            }
            if ((blue_edges[i][0] == 0) && (blue_edges[i][1] != 0)){
                nodeList.add(blue_edges[i][1]);
                colorList.add(1);
                longList.add(1);
                ans[blue_edges[i][1]] = 1;
            }
        }

        int p =0;
        while (p<nodeList.size()){
            int x= nodeList.get(p);
            int color= colorList.get(p);
            int l = longList.get(p);
            if (color == 0){
                List<Integer> temp = buleMap.get(x);
                if (temp != null){
                    for (int i=0;i<temp.size();i++){
                        if (ansc[temp.get(i)][1]== -1){
                            ansc[temp.get(i)][1] = l+1;
                            if (ans[temp.get(i)] == -1){
                                ans[temp.get(i)] = l+1;
                            }
                            nodeList.add(temp.get(i));
                            colorList.add(1);
                            longList.add(l+1);
                        }
                    }
                }
            } else {
                List<Integer> temp = redMap.get(x);
                if (temp != null){
                    for (int i=0;i<temp.size();i++){
                        if (ansc[temp.get(i)][0]== -1){
                            ansc[temp.get(i)][0] = l+1;
                            if (ans[temp.get(i)] == -1){
                                ans[temp.get(i)] = l+1;
                            }
                            nodeList.add(temp.get(i));
                            colorList.add(0);
                            longList.add(l+1);
                        }
                    }
                }
            }
            p=p+1;
        }
        return ans;
    }
}
