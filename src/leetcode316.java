import java.util.Stack;

/**
 * Created by xuanmao on 2019/2/24.
 */
public class leetcode316 {
    public String removeDuplicateLetters(String s) {
        int[] charNum = new int[26];
        boolean[] charUse = new boolean[26];
        for (int i=0;i<s.length();i++){
            charNum[s.charAt(i) - 'a'] ++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (charUse[s.charAt(i)-'a']){
                charNum[s.charAt(i)-'a'] -=1;
                continue;
            }
            while (!stack.empty()){
                Character top = stack.peek();
                if ((top.charValue() >= s.charAt(i)) && (charNum[top.charValue()-'a'] >1)){
                    charNum[top.charValue()-'a'] -=1;
                    charUse[top.charValue()-'a'] = false;
                    stack.pop();
                } else{
                    break;
                }
            }
            stack.push(s.charAt(i));
            charUse[s.charAt(i)-'a'] = true;
        }
        String ans ="";
        while (!stack.empty()){
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
