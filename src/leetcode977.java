/**
 * Created by xuanmao on 2020/10/16.
 */
public class leetcode977 {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int l = 0;
        int r = A.length-1;
        int index =  A.length-1;
        while (l<=r){
            if (A[l]*A[l]<A[r]*A[r]){
                ans[index] = A[r]*A[r];
                index--;
                r--;
            } else {
                ans[index] = A[l]*A[l];
                index--;
                l++;
            }
        }
        return ans;
    }
}
