/**
 * Created by xuanmao on 2019/5/26.
 */
public class leetcode1053 {
    public int[] prevPermOpt1(int[] A) {
        int ni = -1;
        for (int i=1;i<A.length;i++){
            if (A[i]<A[i-1]) {
                ni = i-1;
            }
        }
        System.out.println(ni);
        if (ni==-1){
            return A;
        }
        int sd = A.length-1;
        while (A[sd] >= A[ni]){
            sd = sd-1;
        }
        int temp = A[sd];
        A[sd] = A[ni];
        A[ni] = temp;
        return A;
    }
}
