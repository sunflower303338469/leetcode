import java.util.ArrayList;
import java.util.List;

public class tt4 {
    int [] convert = {0,1,0,0,0,0,9,0,8,6};
    int [] num = {0,1,6,8,9};
    Long maxN;
    int ans =0;
    Long now;
    public int confusingNumberII(int N) {
        maxN = Long.valueOf(N);
        for (int i=1;i<num.length;i++){
            now = Long.valueOf(num[i]);
            recursion();
        }
        return ans;
    }

    private void recursion(){
        if (now>maxN){
            return;
        }
        if (check(now)){
            ans++;
        }
        for (int i=0;i<num.length;i++){
            now = now *10+num[i];
            if (now>maxN){
                now = now /10;
                return;
            }
            recursion();
            now = now /10;
        }
    }

    private boolean check(Long n){
        Long temp = n;
        Long p = 0L;
        while (temp>0){
            Long k = temp % 10;
            p = p*10+convert[k.intValue()];
            temp = temp/10;
        }
        return !n.equals(p);
    }
}
