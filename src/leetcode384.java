import java.util.Random;

/**
 * Created by xuanmao on 2020/8/11.
 */
public class leetcode384 {

    class Solution {

        private int[] original;
        private int[] now;
        public Solution(int[] nums) {
            original = nums;
            now = new int[nums.length];
            for (int i = 0;i<original.length;i++){
                now[i] = original[i];
            }
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            for (int i = 0;i<original.length;i++){
                now[i] = original[i];
            }
            return now;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            Random r = new Random();
            for (int i =0;i<now.length;i++){
                int index = i+ r.nextInt(now.length-i);
                int temp = now[index];
                now[index] = now[i];
                now[i] = temp;
            }
            return now;
        }
    }

}
