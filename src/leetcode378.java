import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xuanmao on 2020/2/18.
 */
public class leetcode378 {
    class Point {
        Integer x;
        Integer y;
        Integer value;

        public Point(Integer x, Integer y, Integer value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.value.compareTo(o2.value);
            }
        };
        PriorityQueue<Point> queue = new PriorityQueue<>(comparator);
        queue.add(new Point(0, 0, matrix[0][0]));
        visit[0][0] = true;
        while (k > 1) {
            Point point = queue.poll();
            if (point == null) {
                return 0;
            }
            if ((point.x + 1 < matrix.length) && (!visit[point.x + 1][point.y])) {
                queue.add(new Point(point.x + 1, point.y, matrix[point.x + 1][point.y]));
                visit[point.x + 1][point.y] = true;
            }
            if ((point.y + 1 < matrix[0].length) && (!visit[point.x][point.y + 1])) {
                queue.add(new Point(point.x, point.y+1,matrix[point.x][point.y+1]));
                visit[point.x][point.y+1] = true;
            }
            k--;
        }
        return queue.peek().value;
    }
}
