/**
 * Created by xuanmao on 2019/10/20.
 */
public class leetcode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pIndex = new int[primes.length];
        int[] value = new int[n];
        value[0] = 1;
        for (int i =1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for (int j =0;j<primes.length;j++){
                if (value[pIndex[j]] * primes[j] < min){
                    min = value[pIndex[j]] * primes[j];
                }
            }
            value[i]= min;
            for (int j =0;j<primes.length;j++){
                if (value[pIndex[j]] * primes[j] == min){
                    pIndex[j]++;
                }
            }
        }
        return value[n-1];
    }
}
