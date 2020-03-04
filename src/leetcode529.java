import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode529 {
    int[] tx = {-1,-1,-1,0,0,1,1,1};
    int[] ty = {-1,0,1,-1,1,-1,0,1};

    public char[][] updateBoard(char[][] board, int[] click) {
        char[][] revealedBoard = new char[board.length][board[0].length];
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i =0;i<board.length;i++){
            for (int j =0;j<board[0].length;j++){
                if ((board[i][j] == 'M') || (board[i][j] == 'X')){
                    revealedBoard[i][j] = 'X';
                } else if (board[i][j] == 'E'){
                    int count = 0;
                    for (int k=0;k<tx.length;k++){
                        int x = i+tx[k];
                        int y = j+ty[k];
                        if ((x>=0) && (x<board.length) && (y>=0) && (y<board[0].length)){
                            if ((board[x][y] == 'M') || (board[x][y] == 'X')){
                                count++;
                            }
                        }
                    }
                    if (count ==0){
                        revealedBoard[i][j] = 'B';
                    } else {
                        revealedBoard[i][j] = (char)('0'+count);
                    }
                } else {
                    revealedBoard[i][j] = board[i][j];
                }
            }
        }
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        xList.add(click[0]);
        yList.add(click[1]);
        visit[click[0]][click[1]] = true;
        int l =0;
        while (l<xList.size()){
            int i = xList.get(l);
            int j = yList.get(l);
            board[i][j] = revealedBoard[i][j];
            if (board[i][j] == 'B') {
                for (int k = 0; k < tx.length; k++) {
                    int x = i + tx[k];
                    int y = j + ty[k];
                    if ((x >= 0) && (x < board.length) && (y >= 0) && (y < board[0].length)) {
                        if (!visit[x][y]){
                            xList.add(x);
                            yList.add(y);
                            visit[x][y] = true;
                        }
                    }
                }
            }
            l++;
        }
        return board;
    }
}
