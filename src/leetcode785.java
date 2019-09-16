import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/14.
 */
public class leetcode785 {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        boolean[] visit = new boolean[graph.length];
        for (int i=0;i<graph.length;i++){
            if (!visit[i]){
                List<Integer> qu = new ArrayList<>();
                visit[i] = true;
                color[i] = 1;
                qu.add(i);
                int l = 0;
                while (l<qu.size()){
                    Integer node = qu.get(l);
                    for (int j = 0;j<graph[node].length;j++){
                        int p = graph[node][j];
                        if (color[p] == color[node]){
                            return false;
                        }
                        if (color[node] == 1){
                            color[p] = 2;
                        } else {
                            color[p] = 1;
                        }
                        if (!visit[p]){
                            visit[p] = true;
                            qu.add(p);
                        }
                    }
                    l= l+1;
                }
            }
        }
        return true;
    }
}
