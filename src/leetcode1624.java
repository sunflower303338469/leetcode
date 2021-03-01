/**
 * Created by xuanmao on 2021/1/8.
 */
public class leetcode1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        int[] pos = new int[26];
        for (int i =0;i<26;i++){
            pos[i] = Integer.MAX_VALUE;
        }
        for (int i =0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            if (pos[index]<i){
                ans = Math.max(ans, i - pos[index]-1);
            } else {
                pos[index] = i;
            }
        }
        return ans;
    }
}
