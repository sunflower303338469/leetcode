import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/2/17.
 */
public class leetcode274 {
    public int hIndex(int[] citations) {
        List<Integer> citList = new ArrayList<>();
        for (int i=0;i<citations.length;i++){
            citList.add(citations[i]);
        }
        citList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        int ans = 0;
        for (int i=0;i<citList.size();i++){
            if (citList.get(i) >= i+1){
                if (ans < i+1){
                    ans = i+1;
                }
            }
        }
        return ans;
    }
}
