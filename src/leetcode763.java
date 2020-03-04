import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/20.
 */
public class leetcode763 {

    public List<Integer> partitionLabels(String S) {
        int[] start = new int[26];
        int[] end = new int[26];
        int[] value = new int[S.length()];
        for (int i=0;i<start.length;i++){
            start[i]=-1;
        }
        for (int i=0;i<S.length();i++){
            int index = S.charAt(i)-'a';
            if (start[index]==-1){
                start[index] = i;
            }
            end[index] = i;
        }
        for (int i =0;i<start.length;i++){
            if (start[i]!=-1){
                value[start[i]]++;
                value[end[i]]--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int sum = 0;
        for (int i=0;i<S.length();i++){
            count++;
            sum = sum+value[i];
            if (sum==0){
                ans.add(count);
                count =0;
            }
        }
        return ans;
    }
}
