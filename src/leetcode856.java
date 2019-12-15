import java.util.Stack;

/**
 * Created by xuanmao on 2019/10/10.
 */
public class leetcode856 {
    public int scoreOfParentheses(String S) {
        int ans = 0;
        int level = 0;
        for (int i =0;i<S.length();i++){
            if (S.charAt(i)== '('){
                level ++;
            } else {
                if (S.charAt(i-1) == '('){
                    ans = ans + getValue(level);
                }
                level--;
            }
        }
        return ans;
    }

    private int getValue(int x){
        return (int)Math.pow(2,x-1);
    }
}
