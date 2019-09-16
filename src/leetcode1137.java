/**
 * Created by xuanmao on 2019/7/28.
 */
public class leetcode1137 {
    public int tribonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 1;
        }
        int a=0;
        int b=1;
        int c =1;
        int ans = a+b+c;
        while (n>3){
            a = b;
            b= c;
            c= ans;
            ans = a+b+c;
            n--;
        }
        return ans;
    }
}
