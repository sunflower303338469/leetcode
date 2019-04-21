import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/4/21.
 */
public class leetcode1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] flag = new boolean[R][C];
        int[][] list = new int[R*C][2];
        int l=0;
        int r=1;
        list[0][0]=r0;
        list[0][1]=c0;
        flag[r0][c0] = true;
        while (l<r){
            int tempR = list[l][0];
            int tempC = list[l][1];
            if ((tempR-1>=0) && (!flag[tempR-1][tempC])){
                list[r][0] = tempR-1;
                list[r][1] = tempC;
                flag[tempR-1][tempC] = true;
                r = r+1;
            }
            if ((tempC-1>=0) && (!flag[tempR][tempC-1])){
                list[r][0] = tempR;
                list[r][1] = tempC-1;
                flag[tempR][tempC-1] = true;
                r = r+1;
            }
            if ((tempR+1<R) && (!flag[tempR+1][tempC])){
                list[r][0] = tempR+1;
                list[r][1] = tempC;
                flag[tempR+1][tempC] = true;
                r = r+1;

            }
            if ((tempC+1<C) && (!flag[tempR][tempC+1])){
                System.out.println(r);
                list[r][0] = tempR;
                list[r][1] = tempC+1;
                flag[tempR][tempC+1] = true;
                r = r+1;

            }
            l = l+1;
        }
        return list;
    }
}
