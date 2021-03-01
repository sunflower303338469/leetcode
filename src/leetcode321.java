/**
 * Created by xuanmao on 2020/12/2.
 */
public class leetcode321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = null;
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);
        for (int i = start; i <= end; i++) {
            int[] a = getList(nums1, i);
            int[] b = getList(nums2, k - i);
            int[] sum = merge(a, b);
            ans = compare(ans, sum);
        }
        return ans;
    }

    private int[] getList(int[] num, int k) {
        int[] ans = new int[k];
        int top = 0;
        for (int i = 0; i < num.length; i++) {
            while (top != 0 && ans[top - 1] < num[i] && (k - top < num.length - i)) {
                top--;
            }
            if (top < k) {
                ans[top] = num[i];
                top++;
            }
        }
        return ans;
    }

    private int[] merge(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];
        int now = 0;
        int l = 0;
        int r = 0;
        while (l < a.length && r < b.length) {
            if (a[l] > b[r]) {
                ans[now] = a[l];
                l++;
                now++;
            } else if (a[l] < b[r]) {
                ans[now] = b[r];
                r++;
                now++;
            } else {
                int x = l;
                int y = r;
                while (x < a.length && y < b.length && a[x] == b[y]) {
                    x++;
                    y++;
                }
                if (x == a.length) {
                    ans[now] = b[r];
                    r++;
                    now++;

                } else if (y == b.length) {
                    ans[now] = a[l];
                    l++;
                    now++;
                } else if (a[x] > b[y]) {
                    ans[now] = a[l];
                    l++;
                    now++;
                } else {
                    ans[now] = b[r];
                    r++;
                    now++;
                }
            }
        }
        while (l < a.length) {
            ans[now] = a[l];
            l++;
            now++;
        }
        while (r < b.length) {
            ans[now] = b[r];
            r++;
            now++;
        }
        return ans;
    }

    private int[] compare(int[] a, int[] b) {
        if (a == null) {
            return b;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return b;
            }
            if (a[i] > b[i]) {
                return a;
            }
        }
        return a;
    }
}
