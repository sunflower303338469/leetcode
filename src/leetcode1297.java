import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/2/26.
 * 滚动哈希
 */
public class leetcode1297 {

    int mod = 1000000007;

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s.length() < minSize) {
            return 0;
        }
        int h = 26;
        int[] count = new int[26];
        int nowLetters = 0;
        int nowValue = 0;
        int ans =0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < minSize - 1; i++) {
            h = (h * 26) % mod;
            if (count[s.charAt(i) - 'a'] == 0) {
                nowLetters++;
            }
            count[s.charAt(i) - 'a']++;
            nowValue = (nowValue * 26 + s.charAt(i) - 'a') % mod;
        }
        for (int i = minSize - 1; i < s.length(); i++) {
            nowValue = (nowValue * 26 + s.charAt(i) - 'a') % mod;
            if (count[s.charAt(i) - 'a'] == 0) {
                nowLetters++;
            }
            count[s.charAt(i) - 'a']++;
            if (i>=minSize){
                nowValue = (nowValue - (h*(s.charAt(i-minSize)-'a')) % mod +mod)%mod;
                count[s.charAt(i-minSize) - 'a']--;
                if (count[s.charAt(i-minSize) - 'a'] == 0) {
                    nowLetters--;
                }
            }
            if (nowLetters<=maxLetters){
                int nowCount = countMap.getOrDefault(nowValue, 0);
                nowCount++;
                ans = Math.max(ans, nowCount);
                countMap.put(nowValue, nowCount);
            }
        }
        return ans;
    }
}
