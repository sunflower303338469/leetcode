import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/4/28.
 */
public class leetcode5040 {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] v = new boolean[grid.length][grid[0].length];
        List<Integer> r = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        int oldColor = grid[r0][c0];
        v[r0][c0] = true;
        r.add(r0);
        c.add(c0);
        int l = 0;

        while (l < r.size()) {
            int nowr = r.get(l);
            int nowc = c.get(l);
            boolean flag = true;
            if ((nowr - 1 >= 0) && (grid[nowr - 1][nowc] == oldColor) && (!v[nowr - 1][nowc])) {
                r.add(nowr - 1);
                c.add(nowc);
                v[nowr - 1][nowc] = true;
            }
            if ((nowr + 1 < grid.length) && (grid[nowr + 1][nowc] == oldColor) && (!v[nowr + 1][nowc])) {
                r.add(nowr + 1);
                c.add(nowc);
                v[nowr + 1][nowc] = true;
            }
            if ((nowc - 1 >= 0) && (grid[nowr][nowc - 1] == oldColor) && (!v[nowr][nowc - 1])) {
                r.add(nowr);
                c.add(nowc - 1);
                v[nowr][nowc - 1] = true;
            }
            if ((nowc + 1 < grid[0].length) && (grid[nowr][nowc + 1] == oldColor) && (!v[nowr][nowc + 1])) {
                r.add(nowr);
                c.add(nowc + 1);
                v[nowr][nowc + 1] = true;
            }
            if ((nowr - 1 < 0) || (!v[nowr - 1][nowc]) ||
                    (nowr + 1 >= grid.length) || (!v[nowr + 1][nowc]) ||
                    (nowc - 1 < 0) || (!v[nowr][nowc - 1]) ||
                    (nowc + 1 >= grid[0].length) || (!v[nowr][nowc + 1])) {
                grid[nowr][nowc] = color;
            }
            l = l + 1;
        }
        return grid;
    }
}
