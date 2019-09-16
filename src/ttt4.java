import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/9/15.
 */
public class ttt4 {
    int[] f ;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        f = new int[n];
        for (int i=0;i<n;i++){
            f[i]=  i;
        }
        Map<Integer, List<Integer>> pathMap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> notUse = new ArrayList<>();
        for (int i=0;i<connections.size();i++){
            int x = connections.get(i).get(0);
            int y = connections.get(i).get(1);
            int fx = getFa(x);
            int fy = getFa(y);
            if (fx!=fy){
                f[fx] = fy;
                pathMap.put(x, connections.get(i));
                pathMap.put(y, connections.get(i));
                ans.add(connections.get(i));
            } else{
                notUse.add(connections.get(i));
            }
        }
        for (int i=0;i<n;i++){
            f[i]=  i;
        }
        for (int i=0;i<notUse.size();i++){
            int x = notUse.get(i).get(0);
            int y = notUse.get(i).get(1);
            int fx = getFa(x);
            int fy = getFa(y);
            if (fx!=fy){
                f[fx] = fy;
                ans.remove(pathMap.get(x));
                ans.remove(pathMap.get(y));
            }
        }

        return ans;
    }

    private int getFa(int x){
        while (f[x]!=x){
            f[x] = f[f[x]];
            x = f[x];
        }
        return f[x];
    }
}
