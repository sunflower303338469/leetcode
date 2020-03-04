/**
 * Created by xuanmao on 2020/2/11.
 */
public class leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n<0){
            return 0;
        }
        if (n==0){
            return 2;
        }
        if (n>10) {
            n = 10;
        }
        int[] f = new int[11];
        f[1] = 10;
        for (int  i =2;i<=n;i++){
            // f[i] = 9*P(9,n-1)+f[i-1];
            f[i] = 9;
            for (int j =9;j>=9-i+2;j--){
                f[i]=f[i]*j;
            }
            f[i] = f[i]+f[i-1];
        }
        return f[n];
    }
}
