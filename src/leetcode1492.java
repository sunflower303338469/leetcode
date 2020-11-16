/**
 * Created by xuanmao on 2020/10/7.
 */
public class leetcode1492 {
    public int kthFactor(int n, int k) {

        for (int i =1;i<=n;i++){
            if (n%i==0){
                k--;
            }
            if (k==0){
                return i;
            }
        }
        return  -1;
    }
}
