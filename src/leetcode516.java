/**
 * Created by xuanmao on 2021/4/28.
 */
public class leetcode516 {
    public int longestPalindromeSubseq(String s) {
        int[][] f = new int[s.length()][s.length()];
        for (int i =0;i<s.length();i++){
            f[i][i]= 1;
        }
        for (int gap = 1;gap<s.length();gap++){
            for (int start=0;start<s.length();start++){
                int end = start+gap;
                if (end>=s.length()){
                    break;
                }
                f[start][end] = Math.max(f[start][end-1], f[start+1][end]);
                if (s.charAt(start) == s.charAt(end)){
                    if (gap>=2){
                        f[start][end] = Math.max(f[start][end],f[start+1][end-1]+2);
                    } else {
                        f[start][end] = Math.max(f[start][end],2);
                    }
                }
            }
        }
        return f[0][s.length()-1];
    }
}
