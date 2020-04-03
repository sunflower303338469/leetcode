/**
 * Created by xuanmao on 2020/3/29.
 */
public class leetcode390 {
    public int lastRemaining(int n) {
        return order(n);
    }

    private int order(Integer n){
        if (n==1){
            return 1;
        }
        return 2*reverse(n/2);
    }

    private int reverse(Integer n){
        if (n==1){
            return 1;
        }
        if (n%2==0){
            return 2*(order(n/2)-1)+1;
        } else {
            return 2*reverse(n/2);
        }
    }
}
