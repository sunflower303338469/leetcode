import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2021/2/25.
 */
public class leetcode264 {
    private static List<Integer> uglyList = generateUglyList();
    public int nthUglyNumber(int n) {
        return uglyList.get(n-1);
    }

    private static List<Integer> generateUglyList(){
        List<Integer> uglyList= new ArrayList<>();
        uglyList.add(1);
        int two = 0;int three= 0; int five = 0;
        for (int  i=2;i<=1690;i++){
            int now = Math.min(uglyList.get(two)*2, Math.min( uglyList.get(three)*3, uglyList.get(five)*5));
            if (now == uglyList.get(two)*2){
                two++;
            }
            if (now == uglyList.get(three)*3){
                three++;
            }
            if (now == uglyList.get(five)*5){
                five++;
            }
            uglyList.add(now);
        }
        return uglyList;
    }
}
