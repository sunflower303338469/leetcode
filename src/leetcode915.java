/**
 * Created by xuanmao on 2019/5/16.
 */
public class leetcode915 {
    public int partitionDisjoint(int[] A) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < A[0]) {
                ans = i;
            }
        }
        for (int i=0;i<ans;i++){
            if (max<A[i]){
                max = A[i];
            }
        }
        for (int i=ans;i<A.length;i++){
            if (A[i]<max){
                ans = i;
            }
        }
        return ans+1 ;
    }
}
