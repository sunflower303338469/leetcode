package notfinish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/2/1.
 */
public class leetcode930 {
    public int numSubarraysWithSum(int[] A, int S) {
        int count = 0;
        List<Integer> zeroList = new ArrayList<>();
        int zeros = 0;
        for (int i =0;i<A.length;i++){
            if (A[i] == 0) {
                zeros += 1;
            }else{
                zeroList.add(zeros);
                zeros = 0;
            }
        }
        zeroList.add(zeros);
        if (zeroList.size()<=S){
            if (S==0){
                return (A.length+1)*A.length/2;
            }
            return 0;
        }
        for (int i =S;i<zeroList.size();i++){
            if (S==0){
                count = count + (zeroList.get(i)+1)*zeroList.get(i)/2;
            } else{
                count = count+(zeroList.get(i-S)+1) * (zeroList.get(i)+1);
            }
        }
        return count;
    }
}
