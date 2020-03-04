import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/2/11.
 */
public class leetcode417 {
    int[] tx = {1,0,-1,0};
    int[] ty = {0,1,0,-1};

    class Point {
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int n = matrix.length;
        if (n==0){
            return new ArrayList<>();
        }
        int m = matrix[0].length;
        if (m==0){
            return new ArrayList<>();
        }
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        List<Point> pacificList = new ArrayList<>();
        List<Point> atlanticList= new ArrayList<>();
        for (int i=0;i<n;i++){
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
            pacificList.add(new Point(i,0));
            atlanticList.add(new Point(i,m-1));
        }
        for (int j=0;j<m;j++){
            pacific[0][j] = true;
            atlantic[n-1][j] = true;
            pacificList.add(new Point(0,j));
            atlanticList.add(new Point(n-1,j));
        }

        int l =0;
        while (l<pacificList.size()){
            Point nowPoint = pacificList.get(l);
            for (int i =0;i<tx.length;i++){
                int tempX = nowPoint.x+tx[i];
                int tempY = nowPoint.y+ty[i];
                if ((tempX>=0) && (tempX<n) && (tempY>=0) && (tempY<m)){
                    if ((matrix[nowPoint.x][nowPoint.y]<=matrix[tempX][tempY]) && (!pacific[tempX][tempY])){
                        pacific[tempX][tempY] = true;
                        pacificList.add(new Point(tempX,tempY));
                    }
                }
            }
            l++;
        }

        l =0;
        while (l<atlanticList.size()){
            Point nowPoint = atlanticList.get(l);
            for (int i =0;i<tx.length;i++){
                int tempX = nowPoint.x+tx[i];
                int tempY = nowPoint.y+ty[i];
                if ((tempX>=0) && (tempX<n) && (tempY>=0) && (tempY<m)){
                    if ((matrix[nowPoint.x][nowPoint.y]<=matrix[tempX][tempY]) && (!atlantic[tempX][tempY])){
                        atlantic[tempX][tempY] = true;
                        atlanticList.add(new Point(tempX,tempY));
                    }
                }
            }
            l++;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j =0;j<m;j++){
                if ( pacific[i][j] && atlantic[i][j]){
                    List<Integer> pointAns = new ArrayList<>();
                    pointAns.add(i);
                    pointAns.add(j);
                    ans.add(pointAns);
                }
            }
        }
        return ans;
    }
}
