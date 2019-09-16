/**
 * Created by xuanmao on 2019/8/14.
 */
public class leetcode9 {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        if (x<10){
            return true;
        }
        long weishu = 10;
        while (x/weishu !=0){
            weishu = weishu*10;
        }
        weishu = weishu/10;
        while (x>0){
            int p = x%10;
            int q = x/(int)weishu;
            System.out.println(p+" "+q);

            if (p!=q){
                return false;
            }
            x = x % (int)weishu;
            x = x /10;
            weishu = weishu/100;


        }
        return true;
    }
}
