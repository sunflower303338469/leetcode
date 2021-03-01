import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2021/2/19.
 */
public class leetcode821 {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        List<Integer> f = new ArrayList<>();
        for (int i =0;i<s.length();i++){
            if (c == s.charAt(i)){
                f.add(i);
            }
        }
        int now = 0;
        for (int i =0;i<s.length();i++){
            if (f.get(now)>=i){
                ans[i] = f.get(now)-i;
            } else if (now+1<f.size()) {
                ans[i] = Math.min(f.get(now+1)-i, i-f.get(now));
                if (i == f.get(now+1)){
                    now++;
                }
            } else {
                ans[i] = i - f.get(now);
            }
        }
        return ans;
    }
}
