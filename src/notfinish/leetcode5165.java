package notfinish;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by xuanmao on 2019/8/25.
 */
public class leetcode5165 {
    class DinnerPlates {

        int capacity;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Stack<Integer>> stackList = new ArrayList<>();

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            while ((!queue.isEmpty()) &&(queue.peek()>=stackList.size())){
                queue.poll();
            }
            if (queue.isEmpty()) {
                Stack<Integer> newStack = new Stack<>();
                newStack.add(val);
                stackList.add(newStack);
                if (capacity>1){
                    queue.add(stackList.size()-1);
                }
            } else {
                Integer index=  queue.peek();
                stackList.get(index).add(val);
                if (stackList.get(index).size()==capacity){
                    queue.poll();
                }
            }
        }

        public int pop() {
            if (stackList.isEmpty()) {
                return -1;
            }
            Stack<Integer> stack = stackList.get(stackList.size() - 1);
            while ((!stackList.isEmpty()) && (stack.isEmpty())) {
                stackList.remove(stackList.size()-1);
                if (stackList.isEmpty()) {
                    break;
                }
                stack = stackList.get(stackList.size() - 1);
            }
            if (stackList.isEmpty()) {
                return -1;
            }
            if (stack.size()==capacity){
                queue.add(stackList.size() - 1);
            }
            return stack.pop();
        }

        public int popAtStack(int index) {
            if (stackList.size() <= index) {
                return -1;
            }
            Stack<Integer> s = stackList.get(index);
            if (s.empty()) {
                return -1;
            }
            if (s.size()==capacity){
                queue.add(index);
            }
            return s.pop();
        }
    }

    @Test
    public void test(){
        DinnerPlates dp = new DinnerPlates(2);
    }
}
