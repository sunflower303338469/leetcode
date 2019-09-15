/**
 * Created by xuanmao on 2019/5/12.
 */
public class leetcode5055 {
    public boolean isRobotBounded(String instructions) {
        int rotate = 0;
        int moveX = 0;
        int moveY = 0;
        for (int i=0;i<instructions.length();i++){
            if (instructions.charAt(i) == 'L'){
                rotate = rotate-1;
                if (rotate == -3){
                    rotate = 1;
                }
            }
            else if (instructions.charAt(i) == 'R'){
                rotate = rotate+1;
                if (rotate ==3){
                    rotate = -1;
                }
            }
            else if (instructions.charAt(i) == 'G'){
                if (rotate == 0){
                    moveX +=1;
                } else if (rotate ==1){
                    moveY +=1;
                } else if (rotate == -1){
                    moveY -=1;
                } else {
                    moveX -=1;
                }
            }
        }
        if ((moveX == 0) && (moveY ==0)){
            return true;
        }
        if ((rotate == 0) && ((moveX !=0) || (moveY != 0))){
            return false;
        }
        return true;
    }
}
