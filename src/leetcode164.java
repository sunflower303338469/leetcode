/**
 * Created by xuanmao on 2020/11/17.
 */
public class leetcode164 {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int gap = (max - min) / nums.length+1;
        int[] maxBlock = new int[nums.length + 1];
        int[] minBlock = new int[nums.length + 1];
        boolean[] exist = new boolean[nums.length + 1];
        for (int i = 0; i < minBlock.length; i++) {
            maxBlock[i] = min + i * gap;
            minBlock[i] = min + (i + 1) * gap - 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / gap;
            System.out.println(nums[i] + " " + index);
            maxBlock[index] = Math.max(maxBlock[index], nums[i]);
            minBlock[index] = Math.min(minBlock[index], nums[i]);
            exist[index] = true;
        }
        int ans = 0;
        int last = min;
        for (int i = 0; i < maxBlock.length; i++) {
            if (exist[i]) {
                ans = Math.max(minBlock[i] - last, ans);
                last = maxBlock[i];
            }
        }
        return ans;
    }
}
