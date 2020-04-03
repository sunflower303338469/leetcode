/**
 * Created by xuanmao on 2020/3/31.
 */
public class leetcode848 {
    public String shiftingLetters(String S, int[] shifts) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=shifts.length-1;i>=0;i--){
            count = (count+shifts[i])% 26;
            int x = S.charAt(i);
            x = (x-'a'+count) %26;
            sb.append((char)(x+'a'));
        }
        return sb.reverse().toString();
    }
}
