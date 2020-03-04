import java.util.Stack;

/**
 * Created by xuanmao on 2019/12/30.
 */
public class leetcode682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i =0;i<ops.length;i++){
            if (ops[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b);
                stack.add(a);
                ans += a+b;
                stack.add(a+b);
            } else if (ops[i].equals("D")){
                int a = stack.peek();
                stack.add(a*2);
                ans+=a*2;
            } else if (ops[i].equals("C")) {
                int a = stack.pop();
                ans -= a;
            } else {
                ans += Integer.valueOf(ops[i]);
                stack.add(Integer.valueOf(ops[i]));
            }
        }
        return ans;
    }
}
