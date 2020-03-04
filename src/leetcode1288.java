import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/2/26.
 */
public class leetcode1288 {

    class Range{
        public Integer start;
        public Integer end;

        public Range(int start ,int end){
            this.start = start;
            this.end = end;
        }
    }
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }
        List<Range> rangeList = new ArrayList<>();
        for (int i =0;i<intervals.length;i++){
            rangeList.add(new Range(intervals[i][0], intervals[i][1]));
        }
        rangeList.sort(Comparator.comparing((Range x)->x.start).thenComparing(p -> -p.end));
        int e = rangeList.get(0).end;
        int ans =1;
        for (int i =1;i<rangeList.size();i++){
            Range nowRange = rangeList.get(i);
            if (nowRange.end>e){
                ans++;
                e = nowRange.end;
            }
        }
        return ans;
    }
}
