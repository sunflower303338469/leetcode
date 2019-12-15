import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xuanmao on 2019/10/7.
 */
public class leetcode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(x-o1)<Math.abs(x-o2)){
                    return -1;
                }
                if (Math.abs(x-o1)>Math.abs(x-o2)){
                    return 1;
                }
                return o1.compareTo(o2);
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for (int i =0;i<arr.length;i++){
            queue.add(arr[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<k;i++){
            ans.add(queue.poll());
        }
        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return ans;
    }
}
