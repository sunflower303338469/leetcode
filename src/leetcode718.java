/**
 * Created by xuanmao on 2021/4/27.
 */
public class leetcode718 {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] f = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    f[i][j] = 1;
                    if (i > 0 && j > 0) {
                        f[i][j] = Math.max(f[i-1][j-1]+1, f[i][j]);
                    }
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }
        return ans;
    }
}
