import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/6/16.
 */
public class leetcode1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int [][] f= new int[str1.length()+1][str2.length()+1];
        int [][] before = new int[str1.length()+1][str2.length()+1];
        for (int i=1;i<str1.length();i++){
            f[i][0] = i;
            before[i][0] = 3;
        }
        for (int i=1;i<str2.length();i++){
            f[0][i] = i;
            before[0][i] = 2;
        }
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    f[i][j] = f[i-1][j-1] +1;
                    before[i][j] = 1;
                } else{
                    if (f[i-1][j] > f[i][j-1]){
                        f[i][j] = f[i][j-1] + 1;
                        before[i][j] = 2;
                    } else {
                        f[i][j] = f[i-1][j] + 1;
                        before[i][j] = 3;
                    }
                }
            }
        }
        int x= str1.length();
        int y= str2.length();
        StringBuffer sb = new StringBuffer();
        while (before[x][y] !=0){
            if (before[x][y] == 1){
                sb.append(str1.charAt(x-1));
                x-=1;
                y-=1;
            } else if (before[x][y] == 2) {
                sb.append(str2.charAt(y-1));
                y-=1;
            } else {
                sb.append(str1.charAt(x-1));
                x-=1;
            }
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
