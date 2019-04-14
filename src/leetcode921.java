/**
 * Created by xuanmao on 2019/4/10.
 */
public class leetcode921 {
    public int minAddToMakeValid(String S) {
        int ans = 0;
        int now = 0;
        for (int i =0;i<S.length();i++){
            if (S.charAt(i) == '('){
                if (now >0){
                    ans = ans + now;
                    now = 0;
                }
                now = now - 1;
            } else if (S.charAt(i) == ')'){
                now = now + 1;
            }
        }
        ans = ans + Math.abs(now);
        return ans;
    }
}
