/**
 * Created by xuanmao on 2019/2/24.
 */
public class leetcode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = 'a';
        int k = 100;
        for (int i=0;i<letters.length;i++){
            int v = ((letters[i] - 'a') - (target - 'a') + 26) % 26;
            if ((v<k) && (v!=0)){
                k = v;
                ans = letters[i];
            }
        }
        return ans;
    }
}
