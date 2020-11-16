/**
 * Created by xuanmao on 2020/9/3.
 */
public class leetcode1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int dis = edges[i][2];
            dist[x][y] = Math.min(dist[x][y], dis);
            dist[y][x] = Math.min(dist[y][x], dis);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((dist[i][k] != Integer.MAX_VALUE) && (dist[k][j] != Integer.MAX_VALUE) && (dist[i][j] > dist[i][k] + dist[k][j])) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int min = n;
        int ans = 0;
        for (int i  =0;i<n;i++){
            int count = 0;
            for (int j=0;j<n;j++){
                if (dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if (min>=count){
                min = count;
                ans= i;
            }
        }
        return ans;
    }
}
