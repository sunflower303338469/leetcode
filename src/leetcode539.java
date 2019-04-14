import java.util.List;

/**
 * Created by xuanmao on 2019/1/25.
 */
public class leetcode539 {
    public int findMinDifference(List<String> timePoints) {
        int[] a = new int[4000];
        for (String s:timePoints){
            int hour = Integer.valueOf(s.substring(0,2));
            int min = Integer.valueOf(s.substring(3,5));
            a[hour*60 + min] +=1;
            a[hour*60 + min + 1440] +=1;
        }

        int min = 4000;
        int last = -4000;
        for (int i=0;i<4000;i++){
            if (a[i]>1) return 0;
            if (a[i] == 1){
                if (i - last<min){
                    min = i - last;
                }
                last = i;
            }
        }
        return min;
    }
}
