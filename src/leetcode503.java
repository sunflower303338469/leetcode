import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuanmao on 2019/2/17.
 */
public class leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        Stack<Integer> valStack = new Stack<>();
        for (int i=0; i<nums.length *2;i++){
            int real = i % nums.length;
            while ((!valStack.empty()) && (nums[real]>nums[valStack.peek()])){
                ansList.set(valStack.peek(), nums[real]);
                valStack.pop();
            }
            if (i<nums.length){
                ansList.add(-1);
                valStack.push(i);
            }
        }
        return ansList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
