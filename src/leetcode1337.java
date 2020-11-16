import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/10/9.
 */
public class leetcode1337 {

    class Row {
        Integer count;
        Integer index;

        public Row(Integer count, Integer index) {
            this.count = count;
            this.index = index;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        List<Row> rowList = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            rowList.add(new Row(count, i));
        }
        rowList.sort(Comparator.comparing((Row p) -> p.count).thenComparing((Row q) -> q.index));
        for (int i = 0; i < k; i++) {
            ans[i] = rowList.get(i).index;
        }
        return ans;
    }
}
