/**
 * Created by xuanmao on 2019/5/23.
 */
public class leetcode526 {
    int ans =0;
    int total;
    boolean[] visited;
    public int countArrangement(int N) {
        total = N;
        visited = new boolean[N+1];
        find(1);
        return ans;
    }
    private void find(int now){
        if (now>total){
            ans = ans+1;
            return;
        }
        for (int i=1;i<=total;i++){
            if (check(i,now)){
                visited[i] =true;
                find(now+1);
                visited[i] = false;
            }
        }
    }
    private boolean check(int i, int now){
        if (visited[i]){
            return false;
        }
        if ((i>=now) && (i % now ==0)){
            return true;
        }
        if ((i<= now) && (now % i ==0)){
            return true;
        }
        return false;
    }
}
