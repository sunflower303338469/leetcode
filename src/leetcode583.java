/**
 * Created by xuanmao on 2020/7/20.
 */
public class leetcode583 {
    public int minDistance(String word1, String word2) {
        int max = 0;
        int[][] f = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
                max  = Math.max(max, f[i][j]);
            }
        }
        return word1.length()+word2.length()-2*max;
    }
}
