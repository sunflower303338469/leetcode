import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2021/3/29.
 */
public class leetcode1653 {
    public int minimumDeletions(String s) {
        List<Integer> value = new ArrayList<>();
        List<Character> c = new ArrayList<>();
        List<Integer> remove = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                value.add(count);
                count = 1;
                c.add(s.charAt(i - 1));
            }
        }
        value.add(count);
        c.add(s.charAt(s.length() - 1));
        int r = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) == 'b') {
                r += value.get(i);
                remove.add(0);
            } else {
                remove.add(r);
            }
        }
        r = 0;
        for (int i = c.size() - 1; i >= 0; i--) {
            if (c.get(i) == 'a') {
                r += value.get(i);
            } else {
                remove.set(i, r);
            }
        }
        int ans = Integer.MAX_VALUE;
        if (c.get(0)=='b'){
            ans = remove.get(0);
        }
        if (c.get(c.size()-1)=='a'){
            ans = Math.min(ans, remove.get(c.size()-1));
        }
        for (int i=1;i<c.size();i++){
            if (c.get(i)=='b'){
                ans = Math.min(ans, remove.get(i-1)+remove.get(i));
            }
        }
        return ans==Integer.MAX_VALUE?0: ans;
    }
}
