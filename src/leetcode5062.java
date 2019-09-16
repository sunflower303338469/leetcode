import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode5062 {
    public int connectSticks(int[] sticks) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(c);
        int ans =0 ;
        for (int i =0;i<sticks.length;i++){
            queue.add(sticks[i]);
        }
        while (queue.size()>1){
            int a =queue.poll();
            int b = queue.poll();
            queue.add(a+b);
            ans = ans + a+b;
        }
        return ans;
    }
}
