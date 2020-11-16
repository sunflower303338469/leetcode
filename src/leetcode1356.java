import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/10/12.
 */
public class leetcode1356 {
    public int[] sortByBits(int[] arr) {
        List<Integer> valueList = new ArrayList<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            valueList.add(arr[i]);
        }
        valueList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = getCount(o1);
                int count2 = getCount(o2);
                if (count1 > count2) {
                    return 1;
                } else if (count1 < count2) {
                    return -1;
                }
                return o1.compareTo(o2);
            }

            private int getCount(int x) {
                int count = 0;
                while (x > 0) {
                    count++;
                    x = x & (x - 1);
                }
                return count;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            ans[i] = valueList.get(i);
        }
        return ans;
    }
}
