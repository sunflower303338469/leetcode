/**
 * Created by xuanmao on 2019/12/30.
 */
public class leetcode1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for (int i =0;i<A.length;i++){
            total +=A[i];
        }
        if (total%3!=0){
            return false;
        }
        int sum = total/3;
        int now = 0;
        int count = 0;
        for (int i=0;i<A.length;i++){
            now = now+A[i];
            if (now == sum){
                count++;
                now=0;
            }
        }
        return count>=3;
    }
}
