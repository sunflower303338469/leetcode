/**
 * Created by xuanmao on 2021/1/26.
 */
public class leetcode907 {


    int mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        return Long.valueOf(getAns(arr, 0, arr.length - 1)).intValue();
    }

    private long getAns(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        if (l > r) {
            return 0;
        }
        long min = arr[l];
        int index = l;
        for (int i = l; i <= r; i++) {
            if (min > arr[i]) {
                index = i;
                min = arr[i];
            }
        }
        long ans = ((((index - l + 1) * (r - index + 1)) %mod) * min) % mod;
        return (ans + getAns(arr, l, index - 1) + getAns(arr, index + 1, r)) % mod;
    }
}
