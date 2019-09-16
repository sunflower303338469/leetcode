import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/9/4.
 */
public class leetcode519 {
    class Solution {
        int row;
        int col;
        int total;
        Map<Integer, Integer> flipMap = new HashMap<>();

        public Solution(int n_rows, int n_cols) {
            row = n_rows;
            col = n_cols;
            total = row * col;
        }

        public int[] flip() {
            int[] ans = new int[2];
            int r = (int) (Math.random() * total);
            Integer f = flipMap.get(r);
            if (f == null) {
                f = r;
            }
            ans[0] = f / col;
            ans[1] = f % col;
            if (r < total - 1) {
                int next=  total-1;
                while (flipMap.containsKey(next)){
                    next = flipMap.get(next);
                }
                flipMap.put(r, next);
            }
            total--;
            return ans;
        }

        public void reset() {
            total = row * col;
            flipMap.clear();
        }
    }
}
