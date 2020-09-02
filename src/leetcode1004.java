import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xuanmao on 2020/6/2.
 */
public class leetcode1004 {

    class Value {
        int count;
        boolean isOne;
    }

    public int longestOnes(int[] A, int K) {
        List<Value> valueList = new ArrayList<>();
        int ans = 0;
        boolean isOne=  A[0]==1;
        int count = 1;
        for (int i =1;i<A.length;i++){
            if (A[i]== A[i-1]){
                count++;
            } else {
                Value value = new Value();
                value.isOne = isOne;
                value.count = count;
                valueList.add(value);
                isOne = !isOne;
                count  =1;
            }
        }
        Value value = new Value();
        value.isOne = isOne;
        value.count = count;
        valueList.add(value);
        int nowK = K;
        Queue<Value> valueQueue = new ArrayDeque<>();
        int nowAns = 0;
        for (Value v:valueList){
            if (v.isOne){
                nowAns+=v.count;
                valueQueue.add(v);
            } else {
                while ((v.count>nowK) && (!valueQueue.isEmpty())) {
                    Value top = valueQueue.poll();
                    if (!top.isOne){
                        nowK+=top.count;
                    }
                    nowAns -= top.count;
                }
                if (v.count <= nowK) {
                    nowK = nowK - v.count;
                    nowAns += v.count;
                    valueQueue.add(v);
                }
            }
            ans = Math.max(ans,nowAns+nowK);
        }

        return Math.min(ans, A.length);
    }
}
