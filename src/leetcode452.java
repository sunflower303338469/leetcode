import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode452 {

    class XValue{
        Integer x;
        Integer value;
        Integer index;
        public XValue(Integer x, Integer value, Integer index){
            this.x = x;
            this.value = value;
            this.index = index;
        }
    }

    public int findMinArrowShots(int[][] points) {
        List<XValue> countList = new ArrayList<>();
        for (int i=0;i<points.length;i++){
            XValue newValue = new XValue(points[i][0], 1,i);
            countList.add(newValue);
            newValue = new XValue(points[i][1], -1,i);
            countList.add(newValue);
        }
        countList.sort(Comparator.comparing((XValue o) -> o.x).thenComparing(p -> -p.value));
        int ans =0;
        int count = 0;
        boolean[] visit = new boolean[points.length];
        List<Integer> wait = new ArrayList<>();
        for (XValue nowValue: countList){
            if (nowValue.value == -1){
                if (visit[nowValue.index]){
                    continue;
                }
                if (count >0){
                    count = 0;
                    ans++;
                    for (Integer i:wait){
                        visit[i] = true;
                    }
                }
            } else {
                count++;
                wait.add(nowValue.index);
            }
        }
        return ans;
    }
}
