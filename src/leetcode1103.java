import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode1103 {
    @Test
    public void test(){
        System.out.println(pathInZigZagTree(26));
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int p = 1;
        while (p<=label){
            p = p*2;
        }
        while (label>=1){
            ans.add(label);
            label = label/2;
            p = p/2;
            int t = p/2;
            label = t+p-1-label;
        }
        List<Integer> a = new ArrayList<>();
        for (int i=ans.size()-1;i>=0;i--){
            a.add(ans.get(i));
        }
        return a;
    }
}
