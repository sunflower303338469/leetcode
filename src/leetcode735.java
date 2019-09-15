import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/4/19.
 */
public class leetcode735 {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<asteroids.length;i++){
            if (asteroids[i]>0){
                stack.push(asteroids[i]);
            } else {
                while (!stack.empty() && (stack.peek()<-asteroids[i])){
                    stack.pop();
                }
                if (stack.empty()){
                    ans.add(asteroids[i]);
                    continue;
                }
                if (stack.peek() == -asteroids[i]){
                    stack.pop();
                }
            }
        }
        for (int i=0;i<stack.size();i++){
            ans.add(stack.get(i));
        }
        int[] re = new int[ans.size()];
        for (int i=0;i<ans.size();i++){
            re[i] = ans.get(i);
        }
        return re;
    }
}
