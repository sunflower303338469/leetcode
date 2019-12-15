/**
 * Created by xuanmao on 2019/10/7.
 */
public class leetcode667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int index = 0;
        int l = 1;
        int r = n;
        boolean flag = true;
        while (k>=1){
            if (flag){
                ans[index] = l;
                l++;
            } else {
                ans[index] = r;
                r--;
            }
            flag= !flag;
            index++;
            k--;
        }
        for (int i=index; i<n;i++){
            ans[i]= flag? r--:l++;

        }
        return ans;
    }
}
