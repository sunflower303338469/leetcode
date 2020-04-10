/**
 * Created by xuanmao on 2020/4/9.
 */
public class leetcode896 {
    public boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean desc = true;
        for (int i =0;i<A.length-1;i++){
            if (A[i]<A[i+1]){
                desc = false;
            }
            if (A[i]>A[i+1]){
                inc = false;
            }
        }
        return inc || desc;
    }
}
