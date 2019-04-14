import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/1/27.
 */
public class leetcode315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> count = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            count.add(0);
            index.add(i);
        }
        merge(0,nums.length, nums, count, index);
        return count;
    }

    private void merge(int l, int r, int[]nums, List<Integer> count, List<Integer> index){
        if (l >= r-1){
            return;
        }
        int mid = (l+r) /2;
        merge(l, mid, nums, count, index);
        merge(mid, r, nums, count, index);
        int x = l,y = mid;
        List<Integer> temp = new ArrayList<>();
        List<Integer> tempIndex = new ArrayList<>();
        while ((x<mid) && (y<r)){
            if (nums[x]>nums[y]) {
                temp.add(nums[x]);
                count.set(index.get(x), count.get(index.get(x)) + (r-y));
                tempIndex.add(index.get(x));
                x = x+1;
            }else{
                temp.add(nums[y]);
                tempIndex.add(index.get(y));
                y = y+1;
            }
        }
        while (x<mid){
            temp.add(nums[x]);
            tempIndex.add(index.get(x));
            x = x+1;
        }
        while (y<r){
            temp.add(nums[y]);
            tempIndex.add(index.get(y));
            y = y+1;
        }
        for (int i=l;i<r;i++){
            nums[i] = temp.get(i-l);
            index.set(i, tempIndex.get(i-l));
        }
    }
}
