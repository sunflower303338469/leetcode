import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/4/10.
 */
public class leetcode729 {
    class MyCalendar {
        private List<Integer> startNum;
        private List<Integer> endNum;
        public MyCalendar() {
            startNum = new ArrayList<>();
            endNum  = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int i=0;i<startNum.size();i++){
                if(!check(start, end, startNum.get(i), endNum.get(i))){
                    return false;
                }
            }
            startNum.add(start);
            endNum.add(end);
            return true;
        }

        private boolean check(int start, int end, int nowStart, int nowEnd){
            if ((start<=nowStart) && (end>nowStart)){
                return false;
            }
            if ((start>=nowStart) && (start<nowEnd)){
                return false;
            }
            return true;
        }
    }
}
