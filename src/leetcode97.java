/**
 * Created by xuanmao on 2020/8/3.
 */
public class leetcode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean[][] f = new boolean[s1.length()+1][s2.length()+1];
        f[0][0] = true;
        for (int i =0;i<s3.length();i++){
            for (int  j =0;j<s1.length();j++){
                if ((i<j) || (i-j>s2.length())){
                    continue;
                }
                if (s3.charAt(i)==s1.charAt(j)){
                    f[j+1][i+1-(j+1)] = f[j+1][i+1-(j+1)] || f[j][i+1-(j+1)];
                    if (f[j+1][i+1-(j+1)]){
                        System.out.println((j+1)+" "+(i+1-(j+1)));
                    }
                }
            }

            for (int j =0;j<s2.length();j++){
                if ((i<j) || (i-j>s1.length())){
                    continue;
                }
                if (s3.charAt(i)==s2.charAt(j)){
                    f[i+1-(j+1)][j+1] = f[i+1-(j+1)][j+1] || f[i+1-(j+1)][j];
                    if (f[i+1-(j+1)][j+1]){
                        System.out.println((i+1-(j+1))+" "+(j+1));
                    }
                }
            }
        }
        return f[s1.length()][s2.length()];
    }
}
