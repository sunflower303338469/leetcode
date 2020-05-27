import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/6.
 */
public class leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i =1;i<nums.length;i++){
            int num = nums[i];
            if ((!list.isEmpty()) && (num>list.get(list.size()-1))){
                list.add(num);
            } else {
                int l =0;
                int r = list.size()-1;
                while (l<r){
                    int mid = (l+r)/2;
                    if (list.get(mid)<num){
                        l = mid+1;
                    } else {
                        r=  mid;
                    }
                }
                list.set(l, num);
            }
            for (int u:list){
                System.out.print(u+ " ");
            }
            System.out.println();
        }

        return list.size();
    }
}
