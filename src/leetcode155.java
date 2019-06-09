import java.util.Stack;

/**
 * Created by xuanmao on 2019/5/23.
 */
public class leetcode155 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.empty() || minStack.peek()>=x){
                minStack.add(x);
            }
            stack.add(x);
        }

        public void pop() {
            if (stack.peek() == null){
                return;
            }
            if (minStack.peek().equals(stack.peek())){
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
