/**
 * Created by xuanmao on 2019/8/27.
 */
public class leetcode680 {
    public boolean validPalindrome(String s) {
        return check(s, true);
    }

    private boolean check(String s, boolean flag){
        int l=0;
        int r= s.length()-1;
        while (l<r){
            if (s.charAt(l) == s.charAt(r)){
                l=l+1;
                r=r-1;
            } else if (flag){
                return check(s.substring(l+1,r+1), false) || check(s.substring(l, r),false);
            } else {
                return false;
            }
        }
        return true;
    }
}
