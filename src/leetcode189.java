/**
 * Created by xuanmao on 2021/1/10.
 */
public class leetcode189 {
    public void rotate(int[] nums, int k) {
        if (k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int gcd = getGcd(nums.length, k);
        for (int j = 0;j<gcd;j++){
            int now = j;
            int temp = nums[j];
            for (int i = 0; i < nums.length/gcd; i++) {
                int next = (now+k) % nums.length;
                int r = nums[next];
                nums[next] = temp;
                temp = r;
                now = next;
            }
        }

    }

    private int getGcd(int x, int y){
        if (y ==0){
            return x;
        }
        return getGcd(y, x% y);
    }
}
