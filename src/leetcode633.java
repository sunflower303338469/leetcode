/**
 * Created by xuanmao on 2019/3/1.
 */
public class leetcode633 {
    public boolean judgeSquareSum(int c) {
        if (c==0){
            return true;
        }
        for (int i = 1; i <= Math.sqrt(c); i++) {
            if (i * i == c) {
                return true;
            }
            int j = (int) Math.sqrt(c - i * i);
            if (i * i + j * j == c) {
                return true;
            }
        }
        return false;
    }
}
