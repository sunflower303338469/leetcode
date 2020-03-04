import java.util.Stack;

/**
 * Created by xuanmao on 2020/2/19.
 */
public class leetcode20 {
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i =0;i<s.length();i++){
            Character c= s.charAt(i);
            switch (c){
                case '(':
                    stack.add(0);
                    break;
                case ')':
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek()==0){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    stack.add(1);
                    break;
                case '}':
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek()==1){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    stack.add(2);
                    break;
                case ']':
                    if (stack.isEmpty()){
                        return false;
                    }
                    if (stack.peek()==2){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
