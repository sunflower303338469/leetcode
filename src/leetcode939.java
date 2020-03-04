import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2020/2/16.
 */
public class leetcode939 {
    private static final int MAX_BORDER = 40000;
    public int minAreaRect(int[][] points) {
        int ans = Integer.MAX_VALUE;
        Set<Integer> intSet = new HashSet<>();
        for (int i =0;i<points.length;i++){
            intSet.add(points[i][0]*100000+points[i][1]);
        }
        for (int i=0;i<points.length;i++){
            for (int j =0; j<points.length;j++){
                    if ((i==j)){
                        continue;
                    }
                    if ((points[i][0]!=points[j][0]) && (points[i][1] != points[j][1])){
                        int x1 = points[i][0];
                        int y1 = points[j][1];
                        int x2 = points[j][0];
                        int y2 = points[i][1];
                        if (((x1>=0) && (y1>=0) && (x1<=MAX_BORDER) && (y1<=MAX_BORDER) && (intSet.contains(x1*100000+y1)))  && ((x2>=0) && (y2>=0) && (x2<=MAX_BORDER) && (y2<=MAX_BORDER) && (intSet.contains(x2*100000+y2)))){
                            ans = Math.min(ans, Math.abs(points[j][0]-points[i][0]) * Math.abs(points[j][1]-points[i][1]));
                        }
                    }
                }
        }
        return ans == Integer.MAX_VALUE? 0 :ans;
    }
}
