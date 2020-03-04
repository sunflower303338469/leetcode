/**
 * Created by xuanmao on 2020/2/11.
 */
public class leetcode794 {
    public boolean validTicTacToe(String[] board) {
        int xx = 0;
        int oo = 0;
        int tripleXX = 0;
        int tripleOO = 0;
        if (board.length != 3) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i].length() != 3) {
                return false;
            }
            for (int j =0;j<board[i].length();j++){
                if (board[i].charAt(j) == 'O'){
                    oo++;
                }
                if (board[i].charAt(j) == 'X') {
                    xx++;
                }
            }
        }
        for (int i =0;i<board.length;i++){
            if (board[i].charAt(0) != ' '){
                if ((board[i].charAt(0)==board[i].charAt(1)) && (board[i].charAt(0)==board[i].charAt(2))){
                    if (board[i].charAt(0) == 'X'){
                        tripleXX++;
                    }else {
                        tripleOO++;
                    }
                }
            }
        }
        for (int i=0;i<board[0].length();i++){
            if (board[0].charAt(i)!=' '){
                if ((board[0].charAt(i)==board[1].charAt(i)) && (board[0].charAt(i)==board[2].charAt(i))){
                    if (board[0].charAt(i) == 'X'){
                        tripleXX++;
                    }else {
                        tripleOO++;
                    }
                }
            }
        }
        if (board[0].charAt(0)!=' '){
            if ((board[0].charAt(0)==board[1].charAt(1)) && (board[0].charAt(0)==board[2].charAt(2))){
                if (board[0].charAt(0) == 'X'){
                    tripleXX++;
                }else {
                    tripleOO++;
                }
            }
        }
        if (board[2].charAt(0)!=' '){
            if ((board[2].charAt(0)==board[1].charAt(1)) && (board[2].charAt(0)==board[0].charAt(2))){
                if (board[2].charAt(0) == 'X'){
                    tripleXX++;
                }else {
                    tripleOO++;
                }
            }
        }

        if ((tripleXX >= 1) && (tripleOO>=1)) {
            return false;
        }
        if ((xx < oo) || (xx-oo>=2)) {
            return false;
        }
        if ((tripleXX>0) && (xx!=oo+1)){
            return false;
        }
        if ((tripleOO>0) && (xx!=oo)){
            return false;
        }
        return true;
    }
}
