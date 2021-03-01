/**
 * Created by xuanmao on 2020/11/18.
 */
public class leetcode1175 {
    public int numPrimeArrangements(int n) {
        int mod = 1000000007;
        int prime = 0;
        for (int i=2;i<=n;i++){
            boolean check = true;
            for (int j=2;j<i;j++){
                if (i%j==0){
                    check =false;
                }
            }
            if (check){
                prime++;
            }
        }
        int notPrime = n - prime;
        long a = 1;
        long b = 1;
        for (int i=notPrime;i>=1;i--){
            a = (a*i) % mod;
        }
        for (int i=prime;i>=1;i--){
            b = (b*i) % mod;
        }
        Long ans = a * b % mod;
        return ans.intValue();
    }
}
