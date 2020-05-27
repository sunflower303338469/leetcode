/**
 * Created by xuanmao on 2020/5/25.
 */
public class leetcode5 {
    public String longestPalindrome(String s) {
        String ans = "";
        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i =0;i<s.length();i++){
            f[i][i] = true;
            ans = ""+s.charAt(i);
        }
        for (int i=1;i<s.length();i++){
            for (int j=0;j<s.length();j++){
                int start = j;
                int end = j+i;
                if (end>=s.length()){
                    break;
                }
                if (s.charAt(start) == s.charAt(end)){
                    if ((start == end-1) || (f[start+1][end-1])){
                        f[start][end] = true;
                        if (end-start+1>ans.length()){
                            ans = s.substring(start,end+1);
                        }
                    }
                }
            }
        }

        return ans;
    }
}
