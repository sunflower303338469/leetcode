import java.util.Map;

public class tt2 {
    public int[][] highFive(int[][] items) {
        int[] max = new int[1001];
        int[] sum = new int[1001];
        boolean[] visit = new boolean[1001];
        for (int t=0;t<5;t++){
            for (int k = 1;k<=1000;k++){
                max[k] = 0;
                int pos = 0;
                for (int i =0;i<items.length;i++){
                    if ((items[i][0]== k) && (max[k]<items[i][1])){
                        max[k] = items[i][1];
                        pos = i;
                    }
                }
                if (max[k]>0) {
                    visit[k] = true;
                    items[pos][1] = 0;
                }
                sum[k] = sum[k]+max[k];
            }
        }
        int h = 0;
        for (int i =1;i<=1000;i++){
            if (visit[i]) h++;
        }
        int [][] ans = new int[h][2];
        h=0;
        for (int i =1;i<=1000;i++){
            if (visit[i]) {
                ans[h][0] = i;
                ans[h][1] = sum[i]/5;
                h++;
            }
        }
        return ans;
    }
}
