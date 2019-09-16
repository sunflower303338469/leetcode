import javax.swing.plaf.synth.SynthScrollBarUI;
import java.util.Stack;

/**
 * Created by xuanmao on 2019/7/23.
 */
public class leetcode946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i =0;
        int j =0;
        while (j<popped.length){
            if ((!stack.empty()) && (stack.peek() == popped[j])){
                stack.pop();
            } else {
                while ((i<pushed.length) && (pushed[i] != popped[j])){
                    stack.push(pushed[i]);
                    i++;
                }
                if (i>=pushed.length){
                    return false;
                }
                i++;
            }
            j++;
        }
        return true;
    }
}
