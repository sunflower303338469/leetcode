import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/10/28.
 */
public class leetcode1002 {
    public List<String> commonChars(String[] A) {
        if (A.length == 0) {
            return new ArrayList<>();
        }
        int[] charCount = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            charCount[A[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] tempCount = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                tempCount[A[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < charCount.length; j++) {
                charCount[j] = Math.min(charCount[j], tempCount[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i =0;i<charCount.length;i++){
            for (int j=0;j<charCount[i];j++){
                ans.add(""+(char)('a'+i));
            }
        }
        return ans;
    }
}
