import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/20.
 */
public class leetcode991 {

    public int brokenCalc(int X, int Y) {
       int ans =0;
       int xx = X;
       int yy = Y;
       while (yy>xx){
           ans++;
           if (yy%2==0){
               yy = yy/2;
           } else {
               yy = yy+1;
           }
       }
        return ans + xx-yy;
    }
}
