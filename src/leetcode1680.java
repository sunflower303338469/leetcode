import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2021/2/25.
 */
public class leetcode1680 {
    int[] cheng = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072};
    int mod = 1000000007;

    public int concatenatedBinary(int n) {
        Long now = 1L;
        List<Integer> value = new ArrayList<>();
        value.add(1);
        for (int i = 2; i <= n; i++) {
            int index = 0;
            while (index<value.size() && value.get(index)==1){
                value.set(index, 0);
                index++;
            }
            if (index>=value.size()){
                value.add(1);
            } else {
                value.set(index, 1);
            }

            now = (now * cheng[value.size()]) % mod;
            now = (now+i)% mod;
        }
        return now.intValue();
    }
}
