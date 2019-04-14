import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/2/11.
 */
public class leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0){
            return ans;
        }
        int start = nums[0];
        int now = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]-now == 1){
                now = nums[i];
            } else{
                ans.add(convertStr(start, now));
                start = nums[i];
                now = nums[i];
            }
        }
        ans.add(convertStr(start, now));
        return ans;
    }

    private String convertStr(int start, int now){
        if (start == now){
            return String.valueOf(start);
        } else {
            return start + "->" + now;
        }
    }
}
