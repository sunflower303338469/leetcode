/**
 * Created by xuanmao on 2020/2/11.
 */
public class leetcode1317 {
    public int[] getNoZeroIntegers(int n) {
        int [] ans = new int[2];
        for (int i=1;i<n;i++){
            if (check(i) && check(n-i)){
                ans[0] = i;
                ans[1] = n-i;
                break;
            }
        }
        return ans;
    }

    private boolean check(int i){
        while (i>0){
            int x = i%10;
            i = i/10;
            if (x==0){
                return false;
            }
        }
        return true;
    }
}
