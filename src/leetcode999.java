/**
 * Created by xuanmao on 2020/5/29.
 */
public class leetcode999 {
    public int numRookCaptures(char[][] board) {
        int ans = 0;
        for (int i =0;i<board.length;i++){
            for (int j  =0;j<board[0].length;j++){
                if (board[i][j] == 'R'){
                    int l =i-1;
                    while (l>=0){
                        if (board[l][j]=='B'){
                            break;
                        }
                        if (board[l][j]=='p'){
                            ans++;
                            break;
                        }
                        l--;
                    }
                    l =i+1;
                    while (l<board.length){
                        if (board[l][j]=='B'){
                            break;
                        }
                        if (board[l][j]=='p'){
                            ans++;
                            break;
                        }
                        l++;
                    }
                    l =j-1;
                    while (l>=0){
                        if (board[i][l]=='B'){
                            break;
                        }
                        if (board[i][l]=='p'){
                            ans++;
                            break;
                        }
                        l--;
                    }
                    l =j+1;
                    while (l<board[0].length){
                        if (board[i][l]=='B'){
                            break;
                        }
                        if (board[i][l]=='p'){
                            ans++;
                            break;
                        }
                        l++;
                    }

                }
            }
        }
        return ans;
    }
}
