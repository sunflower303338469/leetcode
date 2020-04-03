package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/3/6.
 */
public class question57 {
    public int[][] findContinuousSequence(int target) {
        int sum = 0;
        int start = 1;
        int end = 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (end<target){
            sum = sum+end;
            while (sum>target){
                sum = sum - start;
                start++;
            }
            if (sum==target){
                List<Integer> temp = new ArrayList<>();
                for (int i=start;i<=end;i++){
                    temp.add(i);
                }
                ans.add(temp);
            }
            end++;
        }
        int[][] a = new int[ans.size()][];
        for (int i =0;i<ans.size();i++){
            int[] t = new int[ans.get(i).size()];
            for (int j=0;j<ans.get(i).size();j++){
                t[j] = ans.get(i).get(j);
            }
            a[i] = t;
        }
        return a;
    }
}
