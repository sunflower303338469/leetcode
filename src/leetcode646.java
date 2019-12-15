import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/10/10.
 */
public class leetcode646 {

    private class Pair{
        Integer x;
        Integer y;
        public Pair(Integer x, Integer y){
            this.x = x;
            this.y = y;
        }
    }
    public int findLongestChain(int[][] pairs) {
        List<Pair> pairList = new ArrayList<>();
        for (int i =0;i<pairs.length;i++){
            Pair pair = new Pair(pairs[i][0],pairs[i][1]);
            pairList.add(pair);
        }
        pairList.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x.compareTo(o2.x);
            }
        });
        int[] f=  new int[pairList.size()];
        int ans = 0;
        for (int i=pairList.size()-1;i>=0;i--){
            f[i] = 1;
            Pair a = pairList.get(i);
            for (int j=i+1;j<pairList.size();j++){
                Pair b = pairList.get(j);
                if (a.y<b.x){
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
