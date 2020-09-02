/**
 * Created by xuanmao on 2020/5/27.
 */
public class leetcode58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        for (int i =s.length()-1;i>=0;i--){
            if (s.charAt(i)==' '){
                return s.length()-1-i;
            }
        }
        return s.length();
    }
}
