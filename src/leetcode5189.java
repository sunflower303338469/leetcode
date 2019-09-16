/**
 * Created by xuanmao on 2019/9/15.
 */
public class leetcode5189 {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        for (int i =0;i<text.length();i++){
            chars[text.charAt(i)-'a']++;
        }
        int ans = 999999;
        for (int i=0;i<26;i++){
            if (i=='b'-'a'){
                ans = Math.min(ans, chars[i]);
            }
            if (i=='a'-'a'){
                ans = Math.min(ans, chars[i]);
            }
            if (i=='l'-'a'){
                ans = Math.min(ans, chars[i]/2);
            }
            if (i=='o'-'a'){
                ans = Math.min(ans, chars[i]/2);
            }
            if (i=='n'-'a'){
                ans = Math.min(ans, chars[i]);
            }
        }
        return ans;
    }
}
