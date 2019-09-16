import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode407 {
    int[][] vis;
    int[] xmove = {0, 1, 0, -1};
    int[] ymove = {1, 0, -1, 0};
    Queue<Point> queue;

    class Point {
        int x;
        int y;
        Integer height;
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0) {
            return 0;
        }
        int ans = 0;
        vis = new int[heightMap.length][heightMap[0].length];
        queue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.height.compareTo(o2.height);
            }
        });

        for (int i = 0; i < heightMap.length; i++) {
            addQueue(i, 0, heightMap[i][0]);
            addQueue(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]);
        }
        for (int i = 0; i < heightMap[0].length; i++) {
            addQueue(0, i, heightMap[0][i]);
            addQueue(heightMap.length - 1, i, heightMap[heightMap.length - 1][i]);
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            vis[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int tx = x + xmove[i];
                int ty = y + ymove[i];
                if ((tx >= 0) && (tx < heightMap.length) && (ty >= 0) && (ty < heightMap[0].length) && (0 == vis[tx][ty])) {
                    if (heightMap[x][y] > heightMap[tx][ty]) {
                        ans = ans + heightMap[x][y] - heightMap[tx][ty];
                        heightMap[tx][ty] = heightMap[x][y];
                    }
                    addQueue(tx, ty, heightMap[tx][ty]);
                    vis[tx][ty] = 1;
                }
            }
        }
        return ans;
    }

    private void addQueue(int x, int y, int height) {
        Point p = new Point();
        p.x = x;
        p.y = y;
        p.height = height;
        queue.add(p);
    }
}
