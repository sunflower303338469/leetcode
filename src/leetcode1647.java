import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2021/1/12.
 */
public class leetcode1647 {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Set<Integer> countSet = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            while ((count[i] != 0) && (countSet.contains(count[i]))) {
                count[i]--;
                ans++;
            }
            if (count[i] != 0) {
                countSet.add(count[i]);
            }
        }
        return ans;
    }
}
