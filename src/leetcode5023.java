import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class leetcode5023 {
    class Logs {
        Integer ts;
        Integer x;
        Integer y;
    }

    public int earliestAcq(int[][] logs, int N) {
        int[] tag = new int[N];
        for (int i=0;i<N;i++){
            tag[i] = i;
        }
        List<Logs> logsList = new ArrayList<>();
        for (int i=0;i<logs.length;i++){
            Logs logs1 = new Logs();
            logs1.ts = logs[i][0];
            logs1.x = logs[i][1];
            logs1.y = logs[i][2];
            logsList.add(logs1);
        }
        logsList.sort(new Comparator<Logs>() {
            @Override
            public int compare(Logs logs, Logs t1) {
                return logs.ts.compareTo(t1.ts);
            }
        });

        for (Logs log: logsList){
            if (tag[log.x]!=tag[log.y]){
                int p = tag[log.y];
                for (int i=0;i<N;i++){
                    if (tag[i] == p){
                        tag[i] = tag[log.x];
                    }
                }
                boolean flag = true;
                for (int i=0;i<N;i++){
                    if (tag[i]!=tag[log.x]){
                        flag = false;
                    }
                }
                if (flag){
                    return log.ts;
                }
            }
        }
        return -1;
    }
}
