import java.util.ArrayList;
import java.util.List;

public class tt5 {
    int[] v = {0,1,-1,-1,-1,-1,9,-1,8,6};
    public int confusingNumberII(int N) {
        int ans = 0;
        for (int i=0;i<=N;i++){
            if (check(i)){
                ans ++;
                System.out.println(i);
            }
        }
        return ans;
    }

    private boolean check(int i){
        int n = i;
        int p = 0;
        while (n>0){
            int k = n % 10;
            if (v[k] == -1){
                return false;
            }
            p = p*10+v[k];
            n = n/10;
        }
        return !(i==p);
    }
}
