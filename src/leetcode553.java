/**
 * Created by xuanmao on 2019/9/16.
 */
public class leetcode553 {
    public String optimalDivision(int[] nums) {
        StringBuffer sb = new StringBuffer();
        sb.append(nums[0]);
        for (int i=1;i<nums.length;i++){
            sb.append('/');
            if ((i==1) && (nums.length>2)){
                sb.append('(');
            }
            sb.append(nums[i]);
        }
        if (nums.length>2){
            sb.append(')');

        }
        return sb.toString();
    }
}
