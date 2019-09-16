import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/4/11.
 */
public class leetcode947 {
    int[] f = new int[20002];
    public int removeStones(int[][] stones) {
        for (int i =0; i<20002;i++){
            f[i] = i;
        }
        for (int i =0;i<stones.length;i++){
            if (getFather(stones[i][0]) != getFather(10000+stones[i][1])){
                f[getFather(stones[i][0])] = getFather(10000+stones[i][1]);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i =0;i<stones.length;i++){
            set.add(getFather(stones[i][0]));
        }
        return stones.length-set.size();
    }
    private int getFather(int x){
        while (f[x] != x){
            f[x] = f[f[x]];
            x = f[x];
        }
        return f[x];
    }
}