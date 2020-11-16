/**
 * Created by xuanmao on 2020/9/16.
 */
public class leetcode263 {
    public boolean isUgly(int num) {
        if (num == 0){
            return false;
        }
        while (num % 2==0){
            num = num/2;
        }
        while (num%3==0){
            num = num /3;
        }
        while (num%5==0){
            num = num/5;
        }
        return num == 1;
    }
}
