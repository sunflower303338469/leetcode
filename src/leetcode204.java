import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/12/3.
 */
public class leetcode204 {
    public int countPrimes(int n) {
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean p = true;
            for (Integer k : primeList) {
                if (i % k == 0) {
                    p = false;
                    break;
                }
                if (k*k>i){
                    break;
                }
            }
            if (p) {
                primeList.add(i);
            }
        }
        return primeList.size();
    }
}
