import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/10/10.
 */
public class leetcode1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if ((tomatoSlices < cheeseSlices * 2) || (tomatoSlices % 2 != 0)) {
            return new ArrayList<>();
        }
        int x = cheeseSlices * 2;
        int fx = tomatoSlices - x;
        if ((fx % 2 == 0) && (fx <= x)) {
            List<Integer> ans = new ArrayList<>();
            int a = x / 2;
            int b = fx / 2;
            ans.add(b);ans.add(a-b);
            return ans;
        }
        return new ArrayList<>();
    }
}
