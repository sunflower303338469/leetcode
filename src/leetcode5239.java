import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xuanmao on 2019/10/27.
 */
public class leetcode5239 {
    int[] addList = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536};
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> f = new ArrayList<>();
        f.add(0);
        f.add(1);
        if (n==1){
            if (start == 1){
                Collections.reverse(f);
            }
            return f;
        }
        for (int i =2;i<=n;i++){
            int h = f.size()-1;
            int p = f.get(h);
            p = p+addList[i-1];
            f.add(p);
            while (h > 0) {
                int last =  f.get(f.size()-1);
                last = last - (f.get(h) - f.get(h-1));
                f.add(last);
                h--;
            }
        }
        int pos = 0;
        for (int i =0;i<f.size();i++){
            if (f.get(i) == start){
                pos = i;
            }
        }
        for (int i=0;i<f.size();i++){
            ans.add(f.get((pos+i)%addList[n]));
        }
        return ans;
    }
}
