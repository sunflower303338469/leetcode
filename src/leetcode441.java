/**
 * Created by xuanmao on 2019/11/5.
 */
public class leetcode441 {

    public int arrangeCoins(int n) {
        if (n==0){
            return 0;
        }
        int k =1;
        while (n>=k){
            n=n-k;
            k++;
        }
        return --k;
    }
}
