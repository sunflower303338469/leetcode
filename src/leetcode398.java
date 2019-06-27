import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/6/16.
 */
public class leetcode398 {
    class Solution {
        int[] numbers;
        public Solution(int[] nums) {
            numbers = nums;
        }

        public int pick(int target) {
            List<Integer> indexList = new ArrayList<>();
            for (int i =0;i<numbers.length;i++){
                if (numbers[i] == target){
                    indexList.add(i);
                }
            }
            return indexList.get((int) (Math.random() * indexList.size()));
        }
    }
}
