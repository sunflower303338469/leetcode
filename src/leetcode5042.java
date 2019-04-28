import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2019/4/28.
 */
public class leetcode5042 {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        return (find(blocked, source, target) && find(blocked, target, source));
    }
    private boolean find(int[][] blocked, int[] x, int[] y){
        int MAX = 10000;
        Map<Long, Boolean> v = new HashMap<>();
        List<Integer> r = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        r.add(x[0]);
        c.add(x[1]);
        v.put(value(x[0],x[1]), true);
        int l=0;
        while (l<r.size()){
            int nowr = r.get(l);
            int nowc = c.get(l);
            if ((nowr == y[0]) && (nowc == y[1])){
                return true;
            }
            if ((nowr - 1 >= 0) && (check(nowr-1,nowc,blocked))) {
                if (!v.containsKey(value(nowr-1,nowc))){
                    v.put(value(nowr-1,nowc), true);
                    r.add(nowr - 1);
                    c.add(nowc);
                }
            }
            if ((nowr + 1 < 1000000) && (check(nowr+1,nowc,blocked))) {
                if (!v.containsKey(value(nowr+1,nowc))){
                    v.put(value(nowr+1,nowc), true);
                    r.add(nowr + 1);
                    c.add(nowc);
                }
            }
            if ((nowc - 1 >= 0) && (check(nowr,nowc-1,blocked))) {
                if (!v.containsKey(value(nowr,nowc-1))){
                    v.put(value(nowr,nowc-1), true);
                    r.add(nowr);
                    c.add(nowc - 1);
                }
            }
            if ((nowc + 1 < 1000000) && (check(nowr,nowc+1,blocked))) {
                if (!v.containsKey(value(nowr,nowc+1))){
                    v.put(value(nowr,nowc+1), true);
                    r.add(nowr);
                    c.add(nowc + 1);
                }
            }
            l++;
            System.out.println(r.size());
            if (r.size()>MAX){
                return true;
            }
        }
        return false;
    }
    private boolean check(int x, int y, int[][] blocked){
        for (int i=0;i<blocked.length;i++){
            if ((x==blocked[i][0]) && (y==blocked[i][1])){
                return false;
            }
        }
        return true;
    }
    private Long value(int x, int y){
        Long ans = (long)x*1000000;
        return ans + y;
    }
}
