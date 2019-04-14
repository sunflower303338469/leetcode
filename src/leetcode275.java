/**
 * Created by xuanmao on 2019/2/17.
 */
public class leetcode275 {
    public int hIndex(int[] citations) {
        int mid = citations.length / 2;
        int l = 0;
        int r = citations.length;
        while (l < r) {
            if (citations[mid] >= citations.length - mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        return citations.length - mid;
    }
}
