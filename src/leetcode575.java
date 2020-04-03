import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2020/3/29.
 */
public class leetcode575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> type = new HashSet<>();
        int dif = 0;
        int same = 0;
        for (int i =0;i<candies.length;i++){
            if (type.contains(candies[i])){
                same ++;
            } else {
                dif++;
                type.add(candies[i]);
            }
        }
        return Math.min(dif, candies.length/2);
    }
}
