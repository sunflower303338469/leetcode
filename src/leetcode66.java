/**
 * Created by xuanmao on 2020/9/6.
 */
public class leetcode66 {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i =0;i<digits.length;i++){
            if (digits[i]!=9){
                flag = true;
            }
        }
        if (!flag){
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            return ans;
        } else {
            for (int i =digits.length-1;i>=0;i--){
                if (digits[i]!=9){
                    digits[i]+=1;
                    break;
                } else {
                    digits[i]=0;
                }
            }
            return digits;
        }
    }
}
