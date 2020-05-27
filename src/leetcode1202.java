import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by xuanmao on 2020/4/27.
 */
public class leetcode1202 {
    int[] f;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        f=  new int[s.length()];
        for (int i =0;i<s.length();i++){
            f[i] = i;
        }
        for (int i =0;i<pairs.size();i++){
            int a = pairs.get(i).get(0);
            int b = pairs.get(i).get(1);
            a = getFather(a);
            b = getFather(b);
            f[a] = b;
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i =0;i<s.length();i++){
            PriorityQueue<Character> queue = map.getOrDefault(getFather(i), new PriorityQueue<>(Comparator.naturalOrder()));
            queue.add(s.charAt(i));
            map.put(f[i], queue);
        }
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<s.length();i++){
            PriorityQueue<Character> queue = map.getOrDefault(getFather(i), new PriorityQueue<>(Comparator.naturalOrder()));
            if (!queue.isEmpty()){
                sb.append(queue.poll());
            }
            map.put(f[i], queue);
        }
        return sb.toString();
    }

    private int getFather(int x){
        while (f[x]!=x){
            f[x] = f[f[x]];
            x = f[x];
        }
        return f[x];
    }
}
