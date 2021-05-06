/**
 * Created by xuanmao on 2021/5/5.
 */
public class leetcode740 {
    public int deleteAndEarn(int[] nums) {
        int[] f = new int[10001];
        int[] a = new int[10001];
        for (int i =0;i<nums.length;i++){
            a[nums[i]]++;
        }
        for (int i=1;i<=10000;i++){
            if (i>2){
                f[i] = Math.max(f[i-2]+a[i]*i, f[i-1]);
            } else if (i==1){
                f[i] = a[i]*i;
            } else {
                f[i] = Math.max(f[i-1], a[i]*i);
            }
        }
        return f[10000];
    }
}
