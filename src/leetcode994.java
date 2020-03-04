/**
 * Created by xuanmao on 2020/3/4.
 */
public class leetcode994 {

    int[] tx = {0, 1, 0, -1};
    int[] ty = {1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        boolean berotten = true;
        boolean hasFresh = false;
        while (berotten) {
            berotten = false;
            hasFresh = false;
            int[][] nextGrid = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    nextGrid[i][j] = grid[i][j];
                    if (nextGrid[i][j] == 1) {
                        for (int t = 0; t < tx.length; t++) {
                            int tempx = i + tx[t];
                            int tempy = j + ty[t];
                            if ((tempx >= 0) && (tempx < grid.length) && (tempy >= 0) && (tempy < grid[0].length)) {
                                if (grid[tempx][tempy] == 2) {
                                    nextGrid[i][j] = 2;
                                    berotten = true;
                                }
                            }
                        }
                        if (nextGrid[i][j] == 1){
                            hasFresh = true;
                        }
                    }
                }
            }
            grid = nextGrid;
            ans++;
        }
        if (hasFresh){
            return -1;
        }
        return ans-1;
    }
}
