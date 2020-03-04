import java.util.Stack;

/**
 * Created by xuanmao on 2020/2/19.
 */
public class leetcode456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length<3){
            return false;
        }
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i =1;i<nums.length;i++){
            min[i] = Math.min(min[i-1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[nums.length-1]);
        for (int i=nums.length-2;i>0;i--){
            if (nums[i]>min[i]){
                while ((!stack.isEmpty()) && (stack.peek()<=min[i])){
                    stack.pop();
                }
                if ((!stack.isEmpty()) && (stack.peek()<nums[i])){
                    return true;
                }
                stack.add(nums[i]);
            }
        }
        return false;
    }
}
