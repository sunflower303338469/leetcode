/**
 * Created by xuanmao on 2020/6/2.
 */
public class leetcode835 {
    public int largestOverlap(int[][] A, int[][] B) {
        int ans = 0;
        for (int tx = 0;tx<=A.length;tx++){
            for (int ty =0;ty<A[0].length;ty++){
                int a = 0;
                int b = 0;
                for (int i=0;i<A.length;i++){
                    for (int j=0;j<A[0].length;j++){
                        int tempX = i+tx;
                        int tempY = j+ty;
                        if ((tempX<A.length) && (tempY<A[0].length)){
                            if ((A[i][j] == 1) && (B[tempX][tempY]==1)){
                                a++;
                            }
                            if ((B[i][j] == 1) && (A[tempX][tempY]==1)){
                                b++;
                            }
                        }

                    }
                }
                ans = Math.max(ans, a);
                ans = Math.max(ans, b);
            }
        }
        return ans;
    }
}
