import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/3/29.
 */
public class leetcode435 {

    class Interval{
        Integer start;
        Integer end;

        public Interval(Integer start, Integer end){
            this.start = start;
            this.end = end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        intervalList.sort(Comparator.comparing(a -> a.start));
        int ans = 0;
        int end = Integer.MIN_VALUE;
        for (Interval now: intervalList){
            if (now.start<end){
                ans ++;
                end = Math.min(end, now.end);
            } else {
                end = now.end;
            }
        }
        return ans;
    }
}
