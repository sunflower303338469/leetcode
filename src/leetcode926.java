/**
 * Created by xuanmao on 2019/8/9.
 */
public class leetcode926 {
    public int minFlipsMonoIncr(String S) {
        if (S.length()==0){
            return 0;
        }
        int[][] f = new int[S.length()][2];
        if (S.charAt(0) == '0'){
            f[0][1] = 1;
            f[0][0] = 0;
        } else{
            f[0][1] = 0;
            f[0][0] = 1;
        }
        for (int i =1;i<S.length();i++){
            if (S.charAt(i) == '0'){
                f[i][0] = f[i-1][0];
                f[i][1] = Math.min(f[i-1][1],f[i-1][0]) +1;
            } else {
                f[i][0] = f[i-1][0]+1;
                f[i][1] = Math.min(f[i-1][0],f[i-1][1]);
            }
        }
        return Math.min(f[S.length()-1][0],f[S.length()-1][1]);
    }
}
