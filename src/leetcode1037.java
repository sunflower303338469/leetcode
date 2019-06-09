/**
 * Created by xuanmao on 2019/5/5.
 */
public class leetcode1037 {
    public boolean isBoomerang(int[][] points) {
        int a=points[0][0];
        int b=points[0][1];
        int c=points[1][0];
        int d=points[1][1];
        int e=points[2][0];
        int f=points[2][1];
        if ((a==c) && (b==d)){
            return false;
        }
        if ((a==e) && (b==f)){
            return false;
        }
        if ((c==e) && (d==f)){
            return false;
        }
        return !((a-c)*(b-f) == (b-d)*(a-e));
    }
}
