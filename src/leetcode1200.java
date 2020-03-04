import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            elements.add(arr[i]);
        }
        elements.sort(Comparator.naturalOrder());
        Integer min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < elements.size(); i++) {
            int sub = elements.get(i) - elements.get(i - 1);
            if (sub < min) {
                ans.clear();
                List<Integer> value = new ArrayList<>();
                value.add(elements.get(i - 1));
                value.add(elements.get(i));
                ans.add(value);
                min = sub;
            } else if (sub == min) {
                List<Integer> value = new ArrayList<>();
                value.add(elements.get(i - 1));
                value.add(elements.get(i));
                ans.add(value);
            }
        }
        return ans;
    }
}
