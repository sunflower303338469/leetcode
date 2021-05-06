import java.util.TreeSet;

/**
 * Created by xuanmao on 2021/5/5.
 */
public class leetcode1562 {
    public int findLatestStep(int[] arr, int m) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        if (m == arr.length){
            return arr.length;
        }
        treeSet.add(0);
        treeSet.add(arr.length+1);
        for (int i =arr.length-1;i>=0;i--){
            Integer h = treeSet.higher(arr[i]);
            Integer l = treeSet.lower(arr[i]);
            if (h-arr[i]==m+1 || arr[i]-l==m+1){
                return i;
            }
            treeSet.add(arr[i]);
        }
        return -1;
    }
}
