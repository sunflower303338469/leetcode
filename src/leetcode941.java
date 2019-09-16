/**
 * Created by xuanmao on 2019/8/9.
 */
public class leetcode941 {
    public boolean validMountainArray(int[] A) {
        if (A.length<3){
            return false;
        }
        boolean inc = true;
        for (int i=1;i<A.length;i++){
            if (A[i]==A[i-1]){
                return false;
            }

            if ((!inc) && (A[i]>A[i-1])){
                return false;
            }
            if ((i==1) && (A[i]<A[i-1])){
                return false;
            }

            if ((inc) && (A[i]<A[i-1])){
                inc = false;
            }
        }
        return !inc;
    }
}
