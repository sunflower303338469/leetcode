import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2021/4/28.
 */
public class leetcode731 {
    class MyCalendarTwo {


        class Range {
            Integer start;
            Integer end;

            Range(Integer start, Integer end) {
                this.start = start;
                this.end = end;
            }
        }

        List<Range> oneList;
        List<Range> twoList;

        public MyCalendarTwo() {
            oneList = new ArrayList<>();
            twoList = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (Range range:twoList){
                if (start<range.end && end>range.start){
                    return false;
                }
            }
            for (Range range:oneList){
                if (start<range.end && end>range.start){
                    twoList.add(new Range(Math.max(start, range.start), Math.min(end, range.end)));
                }
            }
            oneList.add(new Range(start, end));
            return true;
        }

    }
}
