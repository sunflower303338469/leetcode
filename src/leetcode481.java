import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode481 {
    public int magicalString(int n) {
        if (n==0){
            return 0;
        }
        if (n<=3){
            return 1;
        }
        boolean one = true;
        List<Integer> now = new ArrayList<>();
        now.add(1);now.add(2);now.add(2);
        int index = 2;
        while (n>now.size()){
            int k = now.get(index);
            while (k>0){
                if (one){
                    now.add(1);
                } else {
                    now.add(2);
                }
                k--;
            }
            index++;
            one = !one;
        }
        int ans = 0;
        for (int i=0;i<n;i++){
            if (now.get(i)== 1){
                ans++;
            }
        }
        return ans;
    }
}
