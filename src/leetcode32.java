import java.util.List;
import java.util.Stack;

/**
 * Created by xuanmao on 2019/5/16.
 */
public class leetcode32 {
    public int longestValidParentheses(String s) {
        int[] match = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            }
            if (s.charAt(i) == ')') {
                if (!stack.empty()) {
                    match[i] = i-stack.pop()+1;
                }
            }
        }
        int ans =0;
        for (int i=0;i<s.length();i++){
            if (match[i]>0){
                if ((i-match[i]>=0)){
                    match[i] = match[i] + match[i-match[i]];
                }
            }
            if (match[i]> ans){
                ans = match[i];
            }
        }
        return ans;
    }
}
