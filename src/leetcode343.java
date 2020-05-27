/**
 * Created by xuanmao on 2020/5/26.
 */
public class leetcode343 {

    public int integerBreak(int n) {
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int ans = 1;
        int p = n/3;
        int q = n%3;
        for (int i =0;i<p-1;i++){
            ans= ans*3;
        }
        if (q==1){
            ans = ans *4;
        } else if(q==2){
            ans = ans * 2*3;
        } else{
            ans = ans *3;
        }
        return ans;
    }
}
