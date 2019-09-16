/**
 * Created by xuanmao on 2019/8/9.
 */
public class leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m+1][n+1];
        int[][] values = new int[strs.length][2];
        for (int i =0;i<strs.length;i++){
            for (int j=0;j<strs[i].length();j++){
                if (strs[i].charAt(j) == '0'){
                    values[i][0]++;
                } else {
                    values[i][1]++;
                }
            }
        }
        for (int i =0;i<strs.length;i++){
            for (int j=m;j>=0;j--){
                for (int k=n;k>=0;k--){
                    if ((j>=values[i][0]) && (k>=values[i][1])){
                        f[j][k] = Math.max(f[j][k],f[j-values[i][0]][k-values[i][1]]+1);
                    }
                }
            }
        }

        return f[m][n];
    }
}
