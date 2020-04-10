import java.util.Stack;

/**
 * Created by xuanmao on 2020/4/5.
 */
public class leetcode1381 {
    class CustomStack {

        Stack<Integer> stack = new Stack<>();
        int[] inc;
        int size;

        public CustomStack(int maxSize) {
            size = maxSize;
            inc = new int[maxSize];
        }

        public void push(int x) {
            if (stack.size() < size) {
                stack.add(x);
            }
        }

        public int pop() {
            if (stack.isEmpty()){
                return -1;
            }
            int h = stack.size();
            int add = inc[h-1];
            if ((add>0) && (h-1>0)){
                inc[h-2]+=inc[h-1];
            }
            inc[h-1] = 0;
            return stack.pop()+add;
        }

        public void increment(int k, int val) {
            if (stack.isEmpty()){
                return;
            }
            if (k > stack.size()) {
                inc[stack.size() - 1] += val;
            } else {
                inc[k - 1] += val;
            }
        }
    }

}
