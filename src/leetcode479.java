import org.junit.Test;

/**
 * Created by xuanmao on 2019/11/12.
 */
public class leetcode479 {
    long min;
    long max;

    public int largestPalindrome(int n) {
        if (n==1){
            return 9;
        }
        min = 1;
        max = 9;
        for (int i = 1; i < n; i++) {
            min = min * 10;
            max = max * 10 +9;
        }
        long x = 9L;
        for (int i = 1; i < n; i++) {
            x = x * 10 + 9;
        }
        for (long i = x; i > 0; i--) {
            long value = getValue(i);
            if (value/max>max){
                continue;
            }
            if (check(value)){
                long ans = value%1337;
                return (int)ans;
            }
        }

        return 0;
    }

    private long getValue(long x) {
        long y = x;
        while (x > 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }

    private boolean check(long value){
        for (long i = (long)Math.sqrt(value);i>=min*9;i--){
            if (value%i==0){
                long p = value/i;
                if ((p<=max) && (p>=min)){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(largestPalindrome(8));
    }
}
