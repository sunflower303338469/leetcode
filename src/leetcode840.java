/**
 * Created by xuanmao on 2019/12/10.
 */
public class leetcode840 {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i =0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (check(grid, i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean check(int[][] grid, int x, int y){
        if ((x+2>=grid.length) || (y+2>=grid[0].length)){
            return false;
        }
        int[] xsum = new int[3];
        int[] ysum = new int[3];
        int[] diagonalsSum = new int[2];
        int[] flag = new int[10];
        for (int i =0;i<3;i++){
            for (int j=0;j<3;j++){
                int tempx=  x+i;
                int tempy = y+j;
                if ((grid[tempx][tempy]<0) || (grid[tempx][tempy]>9)){
                    return false;
                }
                flag[grid[tempx][tempy]]++;
                xsum[i] +=grid[tempx][tempy];
                ysum[j] +=grid[tempx][tempy];
                if (i==j){
                    diagonalsSum[0]+=grid[tempx][tempy];
                }
                if (i+j==2){
                    diagonalsSum[1]+=grid[tempx][tempy];
                }
            }
        }
        for (int i=1;i<10;i++){
            if (flag[i] !=1){
                return false;
            }
        }
        for (int i =0;i<3;i++){
            if ((xsum[i] != 15) || (ysum[i]!=15)){
                return false;
            }
        }
        for (int i=0;i<2;i++){
            if (diagonalsSum[i] !=15){
                return false;
            }
        }
        return true;
    }
}
