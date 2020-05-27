import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xuanmao on 2020/4/24.
 */
public class leetcode1014 {

    class Value{
        Integer index;
        Integer v;
        Value(Integer index,Integer v){
            this.index = index;
            this.v = v;
        }
    }

    public int maxScoreSightseeingPair(int[] A) {
        PriorityQueue<Value> leftQueue = new PriorityQueue<>(Comparator.comparing(p->-p.v));
        PriorityQueue<Value> rightQueue = new PriorityQueue<>(Comparator.comparing(p->-p.v));
        for (int i =1;i<A.length;i++){
            rightQueue.add(new Value(i, A[i]-i));
        }
        int ans = 0;
        for (int i =0;i<A.length;i++){
            while ((!rightQueue.isEmpty()) && (rightQueue.peek().index<=i)){
                Value value = rightQueue.poll();
            }
            if (!rightQueue.isEmpty()){
                Value value = rightQueue.peek();
                ans = Math.max(ans, A[i] + value.v + i);
            }
            if (!leftQueue.isEmpty()){
                Value value = leftQueue.peek();
                ans = Math.max(ans, A[i] + value.v - i);
            }
            leftQueue.add(new Value(i, A[i]+i));
        }
        return ans;
    }
}
