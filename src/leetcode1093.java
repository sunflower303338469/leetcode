import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/6/23.
 */
public class leetcode1093 {
    public double[] sampleStats(int[] count) {
        double max = 0;
        double min = -1;
        double avg = 0;
        double zhongweishu = 0;
        double zhongshu = 0;
        double zhongshumax = 0;
        double sum = 0;
        double [] ans = new double[5];

        for (int i=0;i<count.length;i++){
            if (count[i] != 0){
                if (min<0){
                    min = i;
                }
                max = i;
                avg = avg + i * count[i];
                if (count[i]>zhongshumax){
                    zhongshumax = count[i];
                    zhongshu = i;
                }
                sum = sum + count[i];
            }
        }
        int t = 0;
        for (int i=0;i<count.length;i++) {
            if (count[i] == 0){
                continue;
            }
            int p = t+count[i];
            if (count.length%2==0){
                if ((sum/2>t) && (sum/2<=p)){
                    System.out.println(i+" "+p);
                    zhongweishu = zhongweishu + i;
                }
                if ((sum/2+1>t) && (sum/2+1<=p)){
                    System.out.println(i+" "+p);
                    zhongweishu = zhongweishu + i;
                }
            } else {
                if ((sum/2+1>t) && (sum/2+1<=p)){
                    System.out.println(i+" "+p);
                    zhongweishu = i * 2;
                }
            }
            t = p;
        }
        zhongweishu = zhongweishu/2;
        avg = avg/sum;
        ans[0] = min;
        ans[1] = max;
        ans[2] = avg;
        ans[3] = zhongweishu;
        ans[4] = zhongshu;
        return ans;
    }
}
