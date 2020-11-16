import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2020/10/28.
 */
public class leetcode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i =0;i<arr.length;i++){
            count[arr[i]+1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<count.length;i++){
            if (count[i]>0){
                if (set.contains(count[i])){
                    return false;
                }
                set.add(count[i]);
            }
        }
        return true;
    }
}
