import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2019/11/12.
 */
public class leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intset = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            intset.add(nums1[i]);
        }
        Set<Integer> ans = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            if (intset.contains(nums2[i])) {
                ans.add(nums2[i]);
            }
        }
        int[] a = new int[ans.size()];
        int p = 0;
        for (Integer i : ans) {
            a[p] = i;
            p++;
        }
        return a;
    }
}
