import java.util.ArrayList;
import java.util.List;

public class leetcode1134 {
    public boolean isArmstrong(int N) {
        if (N == 0){
            return false;
        }
        int num = N;
        List<Integer> v = new ArrayList<>();
        while (num>0){
            v.add(num % 10);
            num = num/10;
        }
        int ans = 0;
        for (int i:v){
            ans = ans + (int)Math.pow(i, v.size());
        }
        return ans == N;
    }
}
