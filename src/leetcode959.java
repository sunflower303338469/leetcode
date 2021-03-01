import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/11/23.
 */
public class leetcode959 {
    boolean[][][] visit;
    String[] map;
    List<Integer> xList;
    List<Integer> yList;
    List<Integer> zList;

    public int regionsBySlashes(String[] grid) {
        int ans = 0;
        map = grid;
        visit = new boolean[grid.length][grid[0].length()][4];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visit[i][j][k]) {
                        visit[i][j][k] = true;
                        ans++;
                        bfs(i, j, k);
                    }
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j, int k) {
        xList = new ArrayList<>();
        yList = new ArrayList<>();
        zList = new ArrayList<>();
        xList.add(i);
        yList.add(j);
        zList.add(k);
        int l = 0;
        while (l < xList.size()) {
            int nowX = xList.get(l);
            int nowY = yList.get(l);
            int nowZ = zList.get(l);
            if (map[nowX].charAt(nowY) == '\\') {
                if (nowZ == 0) {
                    add(nowX - 1, nowY, 2);
                    add(nowX, nowY, 3);
                } else if (nowZ == 1) {
                    add(nowX, nowY - 1, 3);
                    add(nowX, nowY, 2);
                } else if (nowZ == 2) {
                    add(nowX + 1, nowY, 0);
                    add(nowX, nowY, 1);
                } else {
                    add(nowX, nowY + 1, 1);
                    add(nowX, nowY, 0);
                }

            } else if (map[nowX].charAt(nowY) == '/') {
                if (nowZ == 0) {
                    add(nowX - 1, nowY, 2);
                    add(nowX, nowY, 1);
                } else if (nowZ == 1) {
                    add(nowX, nowY - 1, 3);
                    add(nowX, nowY, 0);
                } else if (nowZ == 2) {
                    add(nowX + 1, nowY, 0);
                    add(nowX, nowY, 3);
                } else {
                    add(nowX, nowY + 1, 1);
                    add(nowX, nowY, 2);
                }
            } else {
                if (nowZ == 0) {
                    add(nowX - 1, nowY, 2);
                    add(nowX, nowY, 1);
                    add(nowX, nowY, 3);
                } else if (nowZ == 1) {
                    add(nowX, nowY - 1, 3);
                    add(nowX, nowY, 0);
                    add(nowX, nowY, 2);
                } else if (nowZ == 2) {
                    add(nowX + 1, nowY, 0);
                    add(nowX, nowY, 3);
                    add(nowX, nowY, 1);
                } else {
                    add(nowX, nowY + 1, 1);
                    add(nowX, nowY, 2);
                    add(nowX, nowY, 0);
                }
            }
            l++;
        }

    }

    private void add(int x, int y, int z) {
        if ((x < 0) || (y < 0) || (x >= visit.length) || y >= visit[0].length) {
            return;
        }
        if (visit[x][y][z]) {
            return;
        }
        visit[x][y][z] = true;
        xList.add(x);
        yList.add(y);
        zList.add(z);
    }
}
