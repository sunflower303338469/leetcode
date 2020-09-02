import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/27.
 */
public class leetcode1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] f = new int[s.length()][26];
        for (int i=0;i<s.length();i++){
            if (i!=0){
                for (int j=0;j<26;j++){
                    f[i][j] = f[i-1][j];
                }
            }
            f[i][s.charAt(i)-'a']++;
        }
        List<Boolean> ans = new ArrayList<>();
        int[] count = new int[26];
        for (int i =0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int k = queries[i][2];
            int odd = 0;
            for (int j =0;j<26;j++){
                count[j] = f[end][j];
            }
            if (start>0){
                for (int j = 0;j<26;j++){
                    count[j] = count[j] - f[start-1][j];
                }
            }
            for (int j =0;j<26;j++){
                if (count[j]%2!=0){
                    odd++;
                }
            }
            ans.add(k*2+1>=odd);
        }
        return ans;
    }
}
