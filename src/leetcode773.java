import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/2/12.
 */
public class leetcode773 {

    int[] end= {1,2,3,4,5,0};
    int des = convertToValue(end);
    int[] tx = {-1,1,-3,3};

    public int slidingPuzzle(int[][] board) {
        int[] newb = new int[6];
        newb[0] = board[0][0];newb[1] = board[0][1];newb[2] = board[0][2];newb[3]=board[1][0];newb[4] = board[1][1];newb[5]=board[1][2];
        int c = convertToValue(newb);
        if (c== des){
            return 0;
        }
        boolean[] visit = new boolean[300000];
        visit[c] = true;
        List<Integer> boardList = new ArrayList<>();
        List<Integer> stepList = new ArrayList<>();
        boardList.add(c);
        stepList.add(0);
        int l = 0;
        while (l<boardList.size()){
            int nowBoard  =boardList.get(l);
            int nowStep = stepList.get(l);
            int zeroIndex = getZero(nowBoard);
            printlog(nowBoard, nowStep);
            for (int i=0;i<tx.length;i++){
                int tempIndex = zeroIndex+tx[i];
                if ((zeroIndex==2 ) && (tempIndex==3)){
                    continue;
                }
                if ((zeroIndex==3 ) && (tempIndex==2)){
                    continue;
                }
                if ((tempIndex>=0) && (tempIndex<newb.length)){
                    int afterValue = swap(nowBoard, zeroIndex, tempIndex);
                    if (afterValue==des){
                        return nowStep+1;
                    }
                    if (!visit[afterValue]){
                        visit[afterValue] = true;
                        boardList.add(afterValue);
                        stepList.add(nowStep+1);
                    }
                }
            }
            l++;
        }
        return -1;
    }

    private int convertToValue(int[] num){
        int value = 0;
        int c = 1;
        for (int i=0;i<num.length;i++){
                value = value + c*num[i];
                c = c*6;
        }
        return value;
    }

    private int getZero(int value){
        int index = 0;
        while (value>0){
            int x = value% 6;
            if (x == 0){
                return index;
            }
            value = value/6;
            index++;
        }
        return index;
    }

    private int swap(int oldValue, int a, int b){
        int v = 0;
        int board = oldValue;
        int index = 0;
        int nowValue = oldValue;
        while (board>0){
            v = board%6;
            if (index == b){
                break;
            }
            board = board/6;
            index++;
        }
        int c = 1;
        for (int i=0;i<6;i++){
            if (i==a){
                nowValue+=v*c;
            }
            if (i==b){
                nowValue-=v*c;
            }
            c = c*6;
        }
        return nowValue;
    }

    private void printlog(int board, int step){
        while (board>0){
            System.out.print(board%6);
            board=board/6;
        }
        System.out.println(" "+step);
    }
}
