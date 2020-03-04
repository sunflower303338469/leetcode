import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/2/12.
 */
public class leetcode916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] minChar = new int[26];
        for (int i =0;i<B.length;i++){
            int[] charCount = new int[26];
            for (int j=0;j<B[i].length();j++){
                charCount[B[i].charAt(j)-'a']++;
            }
            for (int j=0;j<minChar.length;j++){
                minChar[j] = Math.max(minChar[j], charCount[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i=0;i<A.length;i++){
            int[] charCount = new int[26];
            for (int j=0;j<A[i].length();j++){
                charCount[A[i].charAt(j)-'a']++;
            }
            boolean flag = true;
            for (int j=0;j<minChar.length;j++){
                if (charCount[j]<minChar[j]){
                    flag = false;
                }
            }
            if (flag){
                ans.add(A[i]);
            }
        }
        return ans;

    }
}
