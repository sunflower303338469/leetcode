/**
 * Created by xuanmao on 2019/11/21.
 */
public class leetcode400 {
    public int findNthDigit(int n) {
        int now = 9;
        int dig = 1;
        while (n>now* dig){
            n = n-now*dig;
            now = now * 10;
            dig++;
        }
        int k = now /9;
        int p = n/dig;
        n =  n %dig;
        k  = k +p;
        n=dig - n-1;

        while (k>0){
            int v = k % 10;
            k = k /10;
            n--;
            if (n==0){
                return v;
            }
        }
        return k;
    }
}
