/**
 * Created by xuanmao on 2020/9/20.
 */
public class leetcode409 {
    public int longestPalindrome(String s) {
        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 'a') {
                upper[s.charAt(i) - 'A'] = !upper[s.charAt(i) - 'A'];
            } else {
                lower[s.charAt(i) - 'a'] = !lower[s.charAt(i) - 'a'];
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (upper[i]) {
                count++;
            }
            if (lower[i]) {
                count++;
            }
        }
        return count > 0 ? s.length() - count + 1 : s.length();
    }
}
