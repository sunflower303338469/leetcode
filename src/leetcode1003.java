import java.util.Stack;

/**
 * Created by xuanmao on 2019/8/19.
 */
public class leetcode1003 {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<S.length();i++){
            Character c = S.charAt(i);
            if (c=='c'){
                if (stack.size()>=2){
                    Character b= stack.pop();
                    Character a = stack.pop();
                    if ((a=='a') && (b=='b')){
                        continue;
                    }
                }
                return false;
            } else {
                stack.add(c);
            }
        }
        return stack.empty();
    }
}
