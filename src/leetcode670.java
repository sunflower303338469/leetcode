import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/14.
 */
public class leetcode670 {
    public int maximumSwap(int num) {
        if (num==0){
            return 0;
        }
        List<Integer> value = new ArrayList<>();
        while (num>0){
            value.add(num%10);
            num = num/10;
        }
        List<Integer> index = new ArrayList<>();
        List<Integer> biggest = new ArrayList<>();
        index.add(0);
        biggest.add(value.get(0));
        for (int i=1;i<value.size();i++){
            int k = value.get(i);
            if (biggest.get(i-1)<k){
                biggest.add(k);
                index.add(i);
            } else {
                biggest.add(biggest.get(i-1));
                index.add(index.get(i-1));
            }
        }
        for (int i=value.size()-1;i>=0;i--){
            if (biggest.get(i)>value.get(i)){
                int temp = index.get(i);
                int k = value.get(temp);
                value.set(temp, value.get(i));
                value.set(i, k);
                break;
            }
        }
        int ans = 0;
        for (int i=value.size()-1;i>=0;i--){
            ans = ans*10+value.get(i);
        }
        return ans;

    }
}
