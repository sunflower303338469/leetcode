import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/3/13.
 */
public class leetcode130 {

    int[] tx = {0,1,0,-1};
    int[] ty = {1,0,-1,0};

    public void solve(char[][] board) {
        if (board.length==0){
            return;
        }
        char[][] ans = new char[board.length][board[0].length];
        boolean[][] visit=  new boolean[board.length][board[0].length];
        for (int i =0;i<board.length;i++){
            for (int j =0;j<board[0].length;j++){
                ans[i][j] = 'X';
            }
        }
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList=  new ArrayList<>();
        for (int i=0;i<board.length;i++){
            if (board[i][0]=='O'){
                ans[i][0] = 'O';
                xList.add(i);
                yList.add(0);
                visit[i][0] = true;
            }
            if (board[i][board[0].length-1]=='O'){
                ans[i][board[0].length-1] = 'O';
                xList.add(i);
                yList.add(board[0].length-1);
                visit[i][board[0].length-1] = true;
            }
        }
        for (int i=0;i<board[0].length;i++){
            if (board[0][i]=='O'){
                ans[0][i] = 'O';
                xList.add(0);
                yList.add(i);
                visit[0][i] = true;
            }
            if (board[board.length-1][i]=='O'){
                ans[board.length-1][i] = 'O';
                xList.add(board.length-1);
                yList.add(i);
                visit[board.length-1][i] = true;
            }
        }
        int index = 0;
        while (index<xList.size()){
            int nowX = xList.get(index);
            int nowY = yList.get(index);
            for (int i =0;i<4;i++){
                int tempX = nowX+tx[i];
                int tempY = nowY+ty[i];
                if( (tempX>=0) && (tempX<board.length) && (tempY>=0) && (tempY<board[0].length) && (board[tempX][tempY]=='O') && (!visit[tempX][tempY])){
                    visit[tempX][tempY] = true;
                    ans[tempX][tempY] = 'O';
                    xList.add(tempX);
                    yList.add(tempY);
                }
            }
            index++;
        }
        for (int i =0;i<board.length;i++){
            for (int j =0;j<board[0].length;j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}
