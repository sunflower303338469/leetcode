import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/10/9.
 */
public class leetcode970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        int xx = 1;
        while (xx<bound){
            xList.add(xx);
            xx=xx*x;
            if (x <2){
                break;
            }
        }
        int yy = 1;
        while (yy<bound){
            yList.add(yy);
            yy=yy*y;
            if (y <2){
                break;
            }
        }
        for (int i =0;i<xList.size();i++){
            for (int j =0;j<yList.size();j++){
                if (xList.get(i)+yList.get(j)<=bound){
                    ans.add(xList.get(i)+yList.get(j));
                }
            }
        }
        List<Integer> result = ans.stream().collect(Collectors.toList());
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
