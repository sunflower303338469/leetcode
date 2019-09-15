import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/6/14.
 */
public class leetcode368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length ==0){
            return ans;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            numbers.add(nums[i]);
        }
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int [] f = new int[nums.length];
        int [] head = new int[nums.length];
        int index = 0;
        for (int i=0;i<numbers.size();i++){
            f[i] = 1;
            head[i] = i;
            for (int j=0;j<i;j++){
                if ((numbers.get(i) % numbers.get(j) == 0) && (f[i]<f[j]+1)){
                    f[i] = f[j]+1;
                    head[i] = j;
                }
            }
            if (f[i]>f[index]){
                index = i;
            }
        }
        while (head[index] != index){
            ans.add(numbers.get(index));
            index = head[index];
        }
        ans.add(numbers.get(index));
        return ans;
    }

}
