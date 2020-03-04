/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode923 {
    public int threeSumMulti(int[] A, int target) {
        long mod = 1000000000L+7;
        long[] count = new long[101];
        for (int i=0;i<A.length;i++){
            count[A[i]]++;
        }
        long ans = 0;
        for (int i=0;i<=100;i++){
            for (int j=i;j<=100;j++){
                for (int k=j;k<=100;k++){
                    if ((count[i]==0) || (count[j]==0) || (count[k]==0)){
                        continue;
                    }
                    if (i+j+k==target){
                        if (i==k){
                            if ((count[i]>=3)){
                                ans =  (ans + count[i]*(count[i]-1)*(count[i]-2)/6) % mod;
                            }
                        } else if (i==j){
                            if (count[i]>=2){
                                ans =  (ans + count[i]*(count[i]-1)/2*count[k]) % mod;
                            }
                        } else if (j==k){
                            if (count[j]>=2){
                                ans =  (ans + count[j]*(count[j]-1)/2*count[i]) % mod;
                            }
                        } else {
                            ans =  (ans + count[i]*count[j]*count[k]) % mod;
                        }
                        System.out.println(String.format("i:%d j:%d k:%d ans:%d",i,j,k,ans));
                    }
                }
            }
        }
        return (int)ans;
    }
}
