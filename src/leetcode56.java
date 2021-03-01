import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2021/2/19.
 */
public class leetcode56 {

    class Interval {
        public Integer start;
        public Integer end;

        Interval(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> ans = new ArrayList<>();
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        intervalList.sort(Comparator.comparing(p -> p.start));
        int start = intervalList.get(0).start;
        int end = intervalList.get(0).end;
        for (int i = 1; i < intervalList.size(); i++) {
            Interval now = intervalList.get(i);
            if (now.start > end) {
                ans.add(new Interval(start, end));
                start = now.start;
                end = now.end;
            } else {
                end = Math.max(end, now.end);
            }
        }
        ans.add(new Interval(start, end));

        int[][] a = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            a[i][0] = ans.get(i).start;
            a[i][1] = ans.get(i).end;
        }
        return a;
    }
}
