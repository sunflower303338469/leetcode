/**
 * Created by xuanmao on 2020/3/4.
 */
public class leetcode867 {
    public int[][] transpose(int[][] A) {
        if (A.length==0){
            return A;
        }
        int[][] tA = new int[A[0].length][A.length];
        for (int i =0;i<A.length;i++){
            for (int j =0;j<A[0].length;j++){
                tA[j][i] = A[i][j];
            }
        }
        return tA;
    }
}
