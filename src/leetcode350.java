import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/6/12.
 */
public class leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> jiaoji = new ArrayList<>();

        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if (nums1[i]==nums2[j]){
                    jiaoji.add(nums1[i]);
                    nums2[j] = -10000000;
                    break;
                }
            }
        }

        int[] ans = new int[jiaoji.size()];
        for (int i=0;i<jiaoji.size();i++){
            ans[i] = jiaoji.get(i);
        }
        return ans;
    }
}
