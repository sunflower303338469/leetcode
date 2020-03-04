import java.util.List;
import java.util.Stack;

/**
 * Created by xuanmao on 2020/2/28.
 */
public class leetcode636 {

    class Operation{
        Integer time;
        Integer index;
        Boolean start;

        public Operation(Integer index, Boolean start, Integer time){
            this.time = time;
            this.index = index;
            this.start = start;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Operation> operationStack = new Stack<>();
        int[] otherTime = new int[n];
        int[] ans  =new int[n];
        for (String s:logs){
            String[] sList= s.split(":");
            Operation now = new Operation(Integer.valueOf(sList[0]),sList[1].equals("start"),Integer.valueOf(sList[2]));
            if (now.start){
                operationStack.add(now);
            } else {
                if (!operationStack.isEmpty()){
                    Operation start = operationStack.pop();
                    if (start.index.equals(now.index)){
                        ans[start.index] += now.time-start.time+1 - otherTime[start.index];
                        otherTime[start.index] = 0;
                    }
                    if (!operationStack.isEmpty()){
                        Operation before = operationStack.peek();
                        otherTime[before.index] += (now.time-start.time+1);
                    }
                }
            }
        }
        return ans;
    }
}
