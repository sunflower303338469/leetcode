/**
 * Created by xuanmao on 2019/5/19.
 */
public class leetcode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i=0;i<stones.length;i++){
            sum += stones[i];
        }
        int p = sum%2;
        int n = sum/2;
        int[] f = new int[n+1];
        f[0] =1;
        for (int i=0;i<stones.length;i++){
            for (int j=n;j>=0;j--){
                if ((j>=stones[i]) && (f[j-stones[i]]>0)){
                    f[j] = 1;
                }
            }
        }
        int tt = 0;
        for (int i=0;i<=n;i++){
            if (f[i]!=0){
                tt  =i;
            }
        }
        System.out.println(sum + " "+ tt+ " "+n);
        return (n-tt)*2+p;
    }
}
