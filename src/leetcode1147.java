/**
 * Created by xuanmao on 2019/8/4.
 */
public class leetcode1147 {
    public int longestDecomposition(String text) {
        int n = text.length();
        int[] f = new int[n];

        for (int j =0;j<n/2;j++){

            if (text.substring(0,j+1).equals(text.substring(n-j+1,n))){
                f[j] = 1;
            }
            for(int i=0;i<j;i++){
                if (text.substring(i+1,j+1).equals(text.substring(n-j-1,n-i-1))){
                    if (f[i]>0){
                        f[j] = Math.max(f[j],f[i]+1);
                    }
                }
            }
        }
        int ans = 0;
        int index= 0;
        for (int i=0;i<n/2;i++){
            System.out.print(f[i]+ " ");
            if (ans < f[i]){
                ans = f[i];
                index = i;
            }
        }
        if ((index == n/2-1) && (n%2 ==0)){
            if (ans == 0){
                return 1;
            }
           return ans*2;
        } else {
            return ans*2 +1;
        }

    }
}
