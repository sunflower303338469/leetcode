import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2020/8/11.
 */
public class leetcode822 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> sameSet = new HashSet<>();
        for (int i =0;i<fronts.length;i++){
            if (fronts[i]==backs[i]){
                sameSet.add(fronts[i]);
            }
        }
        int max = Integer.MAX_VALUE;
        for (int i =0;i<fronts.length;i++){
            if ((fronts[i]<max) && (!sameSet.contains(fronts[i]))){
                max = fronts[i];
            }
            if ((backs[i]<max) && (!sameSet.contains(backs[i]))){
                max = backs[i];
            }
        }
        return max == Integer.MAX_VALUE ? 0 : max;
    }
}
