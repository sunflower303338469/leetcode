import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/7/5.
 */
public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> value = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            value.add(nums[i]);
        }
        value.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < value.size() - 2; i++) {
            if ((i > 0) && (value.get(i).equals(value.get(i - 1)))) {
                continue;
            }
            int a = value.get(i);
            int l = i + 1;
            int r = value.size() - 1;
            while (l < r) {
                int b = value.get(l);
                int c = value.get(r);
                if (a + b + c == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    ans.add(temp);

                    while ((l<r) && (value.get(l)==b)){
                        l++;
                    }
                    while ((l<r) && (value.get(r)==c)){
                        r--;
                    }
                } else if (a + b + c > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return ans;
    }
}
