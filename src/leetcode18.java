import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/3/4.
 */
public class leetcode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numberList.add(nums[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        numberList.sort(Comparator.naturalOrder());
        for (int i = 0; i < numberList.size(); i++) {
            if ((i != 0) && (numberList.get(i).equals(numberList.get(i - 1)))) {
                continue;
            }
            for (int j = i + 1; j < numberList.size(); j++) {
                if ((j != i + 1) && (numberList.get(j).equals(numberList.get(j - 1)))) {
                    continue;
                }
                int k = j + 1;
                int t = numberList.size() - 1;
                while (k < t) {
                    if (numberList.get(i) + numberList.get(j) + numberList.get(k) + numberList.get(t) < target) {
                        k++;
                    } else if (numberList.get(i) + numberList.get(j) + numberList.get(k) + numberList.get(t) > target) {
                        t--;
                    } else {
                        List<Integer> value = new ArrayList<>();
                        value.add(numberList.get(i));
                        value.add(numberList.get(j));
                        value.add(numberList.get(k));
                        value.add(numberList.get(t));
                        ans.add(value);
                        k++;
                        t--;
                        while ((k < t) && (numberList.get(k).equals(numberList.get(k - 1)))) {
                            k++;
                        }
                        while ((k < t) && (numberList.get(t).equals(numberList.get(t + 1)))) {
                            t--;
                        }
                    }
                }

            }
        }
        return ans;
    }
}
