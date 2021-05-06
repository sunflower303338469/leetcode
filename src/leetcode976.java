import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2021/3/17.
 */
public class leetcode976 {
    public int largestPerimeter(int[] nums) {
        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            line.add(nums[i]);
        }
        line.sort(Comparator.reverseOrder());
        for (int i = 0; i < line.size() - 2; i++) {
            if (line.get(i) < line.get(i + 1) + line.get(i + 2)) {
                return line.get(i) + line.get(i + 1) + line.get(i + 2);
            }
        }
        return 0;
    }
}
