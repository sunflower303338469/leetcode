import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/11/12.'
 * 格雷码生成
 * 1.改变最右边的位元
 * 2.改变从右边数第一个为1的左边的位元
 * 3.循环12
 */
public class leetcode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int now = 0;
        int h = (int)Math.pow(2, n);
        int step = 1;
        while (ans.size()<h){
            if (step==1){
                step = 2;
                now = now ^1;
            } else {
                step = 1;
                int v = 2;
                int k = now;
                while (k%2==0){
                    k = k/2;
                    v = v*2;
                }
                now = now ^ v;
            }
            ans.add(now);
        }
        return ans;
    }
}
