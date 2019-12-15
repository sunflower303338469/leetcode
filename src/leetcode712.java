/**
 * Created by xuanmao on 2019/11/11.
 */
public class leetcode712 {

    public int minimumDeleteSum(String s1, String s2) {
        int[][] f = new int[s1.length()+1][s2.length()+1];
        f[0][0] = 0;
        int sum = 0;
        for (int i =0;i<s1.length();i++){
            sum = sum+ Integer.valueOf(s1.charAt(i));
            f[i+1][0] = sum;
        }
        sum=0;
        for (int i =0;i<s2.length();i++){
            sum = sum+ Integer.valueOf(s2.charAt(i));
            f[0][i+1] = sum;
        }
        for (int i =0;i<s1.length();i++){
            for (int j =0;j<s2.length();j++){
                f[i+1][j+1] = Math.min(f[i][j+1]+Integer.valueOf(s1.charAt(i)),f[i+1][j]+Integer.valueOf(s2.charAt(j)));
                if (s1.charAt(i) == s2.charAt(j)){
                    f[i+1][j+1] = Math.min(f[i+1][j+1], f[i][j]);
                }
            }
        }
        return f[s1.length()][s2.length()];
    }
}
