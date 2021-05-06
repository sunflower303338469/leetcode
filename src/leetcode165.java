/**
 * Created by xuanmao on 2021/4/29.
 */
public class leetcode165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = 0;
        int l2 = 0;
        while (l1 < v1.length || l2 < v2.length) {
            int value1 = 0;
            int value2 = 0;
            if (l1 < v1.length) {
                value1 = Integer.valueOf(v1[l1]);
                l1++;
            }
            if (l2 < v2.length) {
                value2 = Integer.valueOf(v2[l2]);
                l2++;
            }
            if (value1 < value2) {
                return -1;
            }
            if (value2 < value1) {
                return 1;
            }
        }
        return 0;
    }
}
