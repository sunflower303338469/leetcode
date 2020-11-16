/**
 * Created by xuanmao on 2020/9/11.
 */
public class leetcode1025 {
    public boolean divisorGame(int N) {
        boolean[] f =new boolean[N+1];
        f[1] = false;
        for (int i =2;i<=N;i++){
            for (int j =1;j<i;j++){
                int k = i-j;
                if (i%k==0){
                    f[i] = f[i]|| (!f[j]);
                }
            }
        }
        return f[N];
    }
}
