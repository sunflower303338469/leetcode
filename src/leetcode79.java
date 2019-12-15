/**
 * Created by xuanmao on 2019/10/20.
 */
public class leetcode79 {
    boolean[][] visit;
    char[][] a;
    String s;
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    public boolean exist(char[][] board, String word) {
        a = board;
        s = word;
        if (board.length==0){
            if (word.equals("")){
                return true;
            }
            return false;
        }
        visit = new boolean[board.length][board[0].length];
        for (int i =0;i<board.length;i++){
            for (int j =0;j<board[i].length;j++){
                if (a[i][j] == s.charAt(0)){
                    visit[i][j] = true;
                    if (check(i,j,0)){
                        return true;
                    }
                    visit[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean check(int x, int y, int index){
        if (index == s.length()-1){
            return true;
        }
        for (int i=0;i<dx.length;i++){
            int tx = x+dx[i];
            int ty = y+dy[i];
            if ((tx>=0) && (tx<a.length) && (ty>=0) && (ty<a[0].length) && (!visit[tx][ty]) && (s.charAt(index+1) == a[tx][ty])){
                visit[tx][ty] = true;
                if (check(tx,ty,index+1)){
                    return true;
                }
                visit[tx][ty] = false;
            }
        }
        return false;
    }
}
