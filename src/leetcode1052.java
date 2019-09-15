/**
 * Created by xuanmao on 2019/5/26.
 */
public class leetcode1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans =0;
        int addhappy = 0;
        int[] unhappySum = new int[customers.length];
        for (int i=0;i<customers.length;i++){
            if (i>0){
                unhappySum[i] = unhappySum[i-1];
            }
            if (grumpy[i] == 0){
                ans = ans + customers[i];
            } else {
                unhappySum[i] +=customers[i];
            }
        }
        if (X>=customers.length){
            ans = ans + unhappySum[customers.length-1];
            return ans;
        }
        for (int i=X-1;i<customers.length;i++){
            if (i-X>=0){
                addhappy = Math.max(addhappy, unhappySum[i]-unhappySum[i-X]);
            } else {
                addhappy = Math.max(addhappy, unhappySum[i]);
            }
        }
        ans = ans + addhappy;
        return ans;
    }
}
