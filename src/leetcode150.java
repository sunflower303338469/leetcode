import java.util.Stack;

/**
 * Created by xuanmao on 2019/1/25.
 */
public class leetcode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if (tokens[i].equals("+")){
                Integer x = stack.pop();
                Integer y = stack.pop();
                stack.push(y+x);
            } else if (tokens[i].equals("-")){
                Integer x = stack.pop();
                Integer y = stack.pop();
                stack.push(y-x);
            }else if (tokens[i].equals("*")){
                Integer x = stack.pop();
                Integer y = stack.pop();
                stack.push(y*x);
            }else if (tokens[i].equals("/")){
                Integer x = stack.pop();
                Integer y = stack.pop();
                stack.push(y/x);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
