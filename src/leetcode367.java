/**
 * Created by xuanmao on 2020/2/12.
 */
public class leetcode367 {
    public boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }
        for (int i =2;i<num;i++){
            if (i*i==num){
                return true;
            }
        }
        return false;
    }
}
