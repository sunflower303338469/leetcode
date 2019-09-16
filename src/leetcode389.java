/**
 * Created by xuanmao on 2019/8/29.
 */
public class leetcode389 {
    public char findTheDifference(String s, String t) {
        int[] charList = new int[26];
        for (int i=0;i<s.length();i++){
            charList[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++){
            charList[t.charAt(i)-'a']--;
            if (charList[t.charAt(i)-'a']<0){
                return t.charAt(i);
            }
        }
        return '0';
    }
}
