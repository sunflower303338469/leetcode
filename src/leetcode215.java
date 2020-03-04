import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xuanmao on 2020/1/16.
 */
public class leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i =0;i<nums.length;i++){
            if (queue.size()<k){
                queue.add(nums[i]);
            } else {
                if (queue.peek()<nums[i]){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
