import java.util.*;

public class leetcode5035 {

    class Point{
        int x;
        int y;
        Integer value;
    }

    int[] xmove = {0,1,0,-1};
    int[] ymove = {1,0,-1,0};
    public int maximumMinimumPath(int[][] A) {
        int ans = A[0][0];

        boolean[][] vis = new boolean[A.length][A[0].length];
        Comparator<Point> queueComparator = new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                return t1.value.compareTo(point.value);
            }
        };
        Queue<Point> queue = new PriorityQueue<>(queueComparator);
        Point point = new Point();
        point.x =0;
        point.y = 0;
        point.value = A[0][0];
        queue.add(point);
        while (!queue.isEmpty()){
            Point p = queue.poll();
            vis[p.x][p.y] = true;
            ans = Math.min(ans, A[p.x][p.y]);
            for (int i=0;i<4;i++){
                int x = p.x+xmove[i];
                int y = p.y+ymove[i];
                if ((x>=0) && (x<A.length) && (y>=0) && (y<A[0].length) && (!vis[x][y])){
                    vis[x][y] = true;
                    Point point1 = new Point();
                    point1.x=x;
                    point1.y=y;
                    point1.value = A[x][y];
                    queue.add(point1);
                    if ((x==A.length-1) && (y==A[0].length-1)){
                        return Math.min(ans, A[x][y]);
                    }
                }
            }
        }
        return -1;
    }
}
