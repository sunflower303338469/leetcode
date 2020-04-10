/**
 * Created by xuanmao on 2020/4/9.
 */
public class leetcode342 {
    public boolean isPowerOfFour(int num) {
        return (num>0) && (num%3==1) && ((num& (num-1))==0);
    }
}
