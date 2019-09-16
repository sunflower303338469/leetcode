/**
 * Created by xuanmao on 2019/7/7.
 */
public class leetcode1130 {
    public int mctFromLeafValues(int[] arr) {

        int[][] f = new int[arr.length][arr.length];
        int[][] g = new int[arr.length][arr.length];
        int[][] m = new int[arr.length][arr.length];
        for (int i=0;i<arr.length;i++){
            f[i][i] = arr[i];
        }
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                int max = 0;
                for (int k=i;k<=j;k++){
                    if (max<arr[k]){
                        max=  arr[k];
                    }
                }
                m[i][j] = max;
            }
        }
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<arr.length-i;j++){
                int x = j;
                int y = j+i;
                f[x][y] = m[x][x] * m[x+1][y];
                g[x][y] = g[x][x] + g[x+1][y] + f[x][y];
                for (int k =x;k<y;k++){

                    if (g[x][y]>m[x][k]*m[k+1][y] +  g[x][k] + g[k+1][y]){
                        g[x][y] =  g[x][k] + g[k+1][y] +m[x][k]*m[k+1][y];
                    }
                }
                System.out.println(x+ " "+y+" "+g[x][y]);
            }
        }
        return g[0][arr.length-1];
    }
}
