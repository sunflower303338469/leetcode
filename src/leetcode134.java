/**
 * Created by xuanmao on 2020/5/27.
 */
public class leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] m = new int[gas.length];
        int[] sum = new int[gas.length];
        int gasSum=0;
        int costSum = 0;
        for (int i =0;i<gas.length;i++){
            m[i] = gas[i]-cost[i];
            sum[i] = m[i];
            gasSum+=gas[i];
            costSum+=cost[i];
            if (i>0){
                sum[i] = sum[i]+ sum[i-1];
            }
        }
        if (gasSum<costSum){
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int index= -1;
        for (int i =0;i<gas.length;i++){
            if (sum[i]<ans){
                ans = sum[i];
                index= i;
            }
        }
        return (index+1)%gas.length;
    }
}
