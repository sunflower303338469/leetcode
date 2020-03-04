import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/13.
 */
public class leetcode406 {
    class Height {
        Integer height;
        Integer count;
    }

    public int[][] reconstructQueue(int[][] people) {
        List<Height> heightList = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            Height newHeight = new Height();
            newHeight.height = people[i][0];
            newHeight.count = people[i][1];
            heightList.add(newHeight);
        }
        heightList.sort((h1, h2) -> {
            if (h1.count.equals(h2.count)) {
                return h1.height.compareTo(h2.height);
            }
            return h1.count.compareTo(h2.count);
        });
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < heightList.size(); i++) {
            Height h = heightList.get(i);
            boolean flag = true;
            int k = 0;
            for (int j = 0; j < i; j++) {
                if (h.height <= ans[j][0]) {
                    k++;
                    if (k == h.count+1) {
                        for (int p = i; p > j; p--) {
                            ans[p][0] = ans[p - 1][0];
                            ans[p][1] = ans[p - 1][1];
                        }
                        ans[j][0] = h.height;
                        ans[j][1] = h.count;
                        System.out.println("h " + h.height+" c "+h.count+" j "+(j-1));
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                ans[i][0] = h.height;
                ans[i][1] = h.count;
                System.out.println("h " + h.height+" c "+h.count+" j "+i);
            }

        }
        return ans;
    }
}
