/**
 * Created by xuanmao on 2019/6/12.
 */
public class leetcode693 {
    public boolean hasAlternatingBits(int n) {
        int p = n%2;
        while (n>0){
            n = n/2;
            if (p== n%2){
                return false;
            }
            p = n%2;
        }
        return true;
    }
}
