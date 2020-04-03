import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/3/4.
 */
public class leetcode990 {

    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int[] f = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i =0;i<26;i++){
            f[i] = i;
        }
        List<Pair> combine = new ArrayList<>();
        List<Pair> query = new ArrayList<>();
        for (int i =0;i<equations.length;i++){
            Pair pair = new Pair(equations[i].charAt(0)-'a',equations[i].charAt(3)-'a');
            if (equations[i].charAt(1)=='='){
                combine.add(pair);
            } else {
                query.add(pair);
            }
        }
        for (Pair pair:combine){
            f[getFather(pair.x)] = getFather(pair.y);
        }
        for (Pair pair:query){
            if (getFather(pair.x)==getFather(pair.y)){
                return false;
            }
        }
        return true;

    }

    private int getFather(int x){
        while (f[x]!=x){
            f[x] = f[f[x]];
            x = f[x];
        }
        return f[x];
    }
}
