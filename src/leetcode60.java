/**
 * Created by xuanmao on 2019/5/23.
 */
public class leetcode60 {
    int num = 0;
    int[] pailie;
    boolean[] visited;
    int total;
    int place;

    public String getPermutation(int n, int k) {
        pailie = new int[n];
        visited = new boolean[n + 1];
        total = n;
        place = k;
        return getPer(0);
    }

    private String getPer(int x) {
        if (x >= total) {
            num++;
            if (num == place) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < total; i++) {
                    stringBuilder.append(pailie[i]);
                }
                return stringBuilder.toString();
            }
            return null;
        }
        String ans = null;
        for (int i = 1; i <= total; i++) {
            if ((ans == null) && (!visited[i])) {
                visited[i] = true;
                pailie[x] = i;
                ans = getPer(x + 1);
                visited[i] = false;
            }
        }
        return ans;
    }
}
