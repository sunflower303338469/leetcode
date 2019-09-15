import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/5/5.
 */
public class test4 {
    public int[] numMovesStonesII(int[] stones) {
        int[] ans = new int[2];
        List<Integer> a = new ArrayList<>();
        for (int i=0;i<stones.length;i++){
            a.add(stones[i]);
        }
        a.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        List<Integer> val = new ArrayList<>();
        for (int i=1;i<a.size();i++){
            val.add(a.get(i) - a.get(i-1)-1);
        }
        int max = 0;
        for (Integer v:val){
            max = max + v;
        }
        if (val.get(0)<val.get(val.size()-1)){
            max = max - val.get(0);
        } else {
            max = max -val.get(val.size()-1);
        }
        ans[1] = max;


        return ans;
    }
}
