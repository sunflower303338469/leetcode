import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode954 {
    public boolean canReorderDoubled(int[] A) {
        List<Integer> numList = new ArrayList<>();
        for (int i =0;i<A.length;i++){
            if (A[i]>0){
                numList.add(A[i]);
            }
        }
        if (!check(numList)){
            return false;
        }
        numList.clear();
        for (int i =0;i<A.length;i++){
            if (A[i]<0){
                numList.add(-A[i]);
            }
        }
        return check(numList);
    }

    public boolean check(List<Integer> numList){
        boolean[] visit = new boolean[numList.size()];
        numList.sort(Comparator.naturalOrder());
        Map<Integer, Integer> firstIndex = new HashMap<>();
        for (int i=0;i<numList.size();i++){
            if (!firstIndex.containsKey(numList.get(i))){
                firstIndex.put(numList.get(i), i);
            }
        }
        for (int i =0;i<numList.size();i++){
            if (!visit[i]){
                visit[i] = true;
                int doubleValue = numList.get(i)*2;
                if (firstIndex.containsKey(doubleValue)){
                    int index = firstIndex.get(doubleValue);
                    visit[index] = true;
                    index++;
                    if ((index>=numList.size()) || (numList.get(index)!=doubleValue)){
                        firstIndex.remove(doubleValue);
                    } else {
                        firstIndex.put(doubleValue, index);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
