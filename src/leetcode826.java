
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/12/30.
 */
public class leetcode826 {

    class Work{
        Integer difficulty;
        Integer profit;
        public Work(int difficulty, int profit){
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Work> workList= new ArrayList<>();
        for (int i =0;i<difficulty.length;i++){
            workList.add(new Work(difficulty[i], profit[i]));
        }
        workList.sort(Comparator.comparing(work -> work.difficulty));
        int[] f= new int[100001];
        int l=0;
        for (int i=1;i<100001;i++){
            f[i] = f[i-1];
            while ((l<workList.size()) && (workList.get(l).difficulty<=i)){
                f[i] = Math.max(f[i], workList.get(l).profit);
                l++;
            }
        }
        int ans =0;
        for (int i =0;i<worker.length;i++){
            ans+=f[worker[i]];
        }
        return ans;
    }
}
