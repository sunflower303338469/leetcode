/**
 * Created by xuanmao on 2019/8/26.
 */
public class leetcode231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n!=1){
            if (n%2==0){
                n =n/2;
            } else {
                return false;
            }
        }
        return true;
    }
}
