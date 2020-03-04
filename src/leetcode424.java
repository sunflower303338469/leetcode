/**
 * Created by xuanmao on 2020/2/23.
 */
public class leetcode424 {
    public int characterReplacement(String s, int k) {
        int[] f = new int[26];
        int nowMax = 0;
        int start = 0;
        for (int i =0;i<s.length();i++){

            f[s.charAt(i)-'A']++;
            nowMax = Math.max(nowMax, f[s.charAt(i)-'A']);
            if (nowMax+k<i-start+1){
                f[s.charAt(start)-'A']--;
                start++;
            }
        }
        return s.length()-start;
    }
}
