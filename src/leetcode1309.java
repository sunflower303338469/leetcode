/**
 * Created by xuanmao on 2020/11/16.
 */
public class leetcode1309 {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int i =0;i<nums.length;i++){
            int count = 0;
            int value = 0;
            for (int j=1;j*j<=nums[i];j++){
                if (nums[i]%j==0){
                    if (j*j==nums[i]){
                        value+=j;
                        count+=1;
                    } else {
                        value += nums[i]/j+j;
                        count+=2;
                    }
                }
            }
            if (count== 4){
                ans +=value;
            }
        }
        return ans;
    }
}
