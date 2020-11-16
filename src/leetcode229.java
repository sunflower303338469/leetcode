import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/4.
 */
public class leetcode229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length==0){
            return new ArrayList<>();
        }
        int num1 = nums[0];
        int score1 = 0;
        int num2 = nums[0];
        int score2= 0;
        for (int i=0;i<nums.length;i++){
            int nowNum = nums[i];
            if (nowNum==num1){
                score1++;
            } else if (nowNum == num2){
                score2++;
            } else if (score1==0) {
                num1=  nowNum;
                score1=1;
            }else if(score2==0) {
                num2=nowNum;
                score2=1;
            }else {
                score1--;
                score2--;
            }
        }
        List<Integer> ans  =new ArrayList<>();
        int count1=0;
        int count2=0;
        for (int i =0;i<nums.length;i++){
            int nowNum = nums[i];
            if (nowNum==num1){
                count1++;
            } else if (nowNum==num2){
                count2++;
            }
        }
        if (count1*3>nums.length){
            ans.add(num1);
        }
        if (count2*3>nums.length){
            ans.add(num2);
        }
        return ans;
    }
}
