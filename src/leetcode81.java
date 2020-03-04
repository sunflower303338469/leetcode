/**
 * Created by xuanmao on 2020/2/12.
 */
public class leetcode81 {

    int[] n;
    int t;

    public boolean search(int[] nums, int target) {
        n = nums;
        t = target;
        return find(0, nums.length - 1);
    }

    boolean find(int start, int end) {
        System.out.println("find "+ start + " "+ end);
        if (end<start){
            return false;
        }
        if ((n[start] == t) || (n[end] == t)) {
            return true;
        }
        if (end - start < 2) {
            return false;
        }
        int mid = (start + end) / 2;
        if (n[mid] == t) {
            return true;
        }
        if (n[start] < n[mid]) {
            if ((t > n[start]) && (t < n[mid])) {
                return binaryFind(start + 1, mid - 1);
            } else {
                return find(mid + 1, end - 1);
            }
        }
        if (n[mid] < n[end]) {
            if ((t > n[mid]) && (t < n[end])) {
                return binaryFind(mid + 1, end - 1);
            } else {
                return find(start + 1, mid - 1);
            }
        }
        return find(start+1, mid-1) || find(mid+1, end-1);
    }

    boolean binaryFind(int start, int end) {
        System.out.println("binaryFind "+ start + " "+ end);
        int l=start;
        int r =end;
        while (l<=r){
            int mid = (l+r)/2;
            if (n[mid] == t){
                return true;
            }
            if (n[mid]<t){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return false;
    }
}
