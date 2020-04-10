/**
 * Created by xuanmao on 2020/4/5.
 */
public class leetcode647 {

    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i =0;i<s.length();i++){
            f[i][i] = true;
            ans++;
        }
        for (int i=1;i<s.length();i++){
            for (int j=0;j<s.length();j++){
                int k = j+i;
                if (k>=s.length()){
                    continue;
                }
                if (s.charAt(j) == s.charAt(k)){
                    if ((j+1==k) || (f[j+1][k-1])){
                        f[j][k] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
