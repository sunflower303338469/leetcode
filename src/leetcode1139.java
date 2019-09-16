/**
 * Created by xuanmao on 2019/7/28.
 */
public class leetcode1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int [][] col = new int[grid.length][grid[0].length];
        int [][] row =  new int[grid.length][grid[0].length];
        int [][] sum =  new int[grid.length][grid[0].length];
        if ((grid.length==1) && (grid[0].length == 1)){
            return grid[0][0];
        }
        for (int i =0;i<grid.length;i++){
            for (int j =0;j<grid[i].length;j++){

                if (j>0){
                    row[i][j] = row[i][j-1] + grid[i][j] ;
                } else {
                    row[i][j] =  grid[i][j] ;
                }
                if (i>0){
                    col[i][j] = col[i-1][j] + grid[i][j] ;
                } else {
                    col[i][j] = grid[i][j] ;
                }
                sum[i][j] = 0;
                if (i>0){
                    sum[i][j] += sum [i-1][j];
                }
                sum[i][j] +=row[i][j];
            }
        }
        int ans = 0;
        int max = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=i;j<grid.length;j++){
                for (int k=0;k<grid[0].length;k++){
                    int t=k+j-i;
                    int size = j-i+1;
                    if (t>=grid[0].length){
                        continue;
                    }
                    boolean isOk = true;

                    isOk = isOk && (((k>0) && (row [i][t] - row[i][k-1] == size)) || ((k==0) && (row[i][t]>=size)));
                    isOk = isOk && (((k>0) && (row [j][t] - row[j][k-1] == size)) || ((k==0) &&(row[j][t]>=size)));
                    isOk = isOk && (((i>0) && (col[j][k] - col[i-1][k] == size)) || ((i==0) &&(col[j][k]>=size)));
                    isOk = isOk && (((i>0) && (col[j][t] - col[i-1][t] == size)) || ((i==0) &&(col[j][t]>=size)));

                    if (isOk){
                        System.out.println(i+" "+j+" "+k+" "+t);
                        if (max<size){
                            max = size;
                        }
                    }
                }
            }
        }
        return max *max ;
    }
}
