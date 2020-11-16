import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/10/7.
 */
public class leetcode401 {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (check(i, j, num)) {
                    if (j >= 10) {
                        ans.add("" + i + ":" + j);
                    } else {
                        ans.add("" + i + ":0" + j);
                    }
                }
            }
        }
        return ans;
    }

    private boolean check(int i, int j, int num) {
        return (getCount(i) + getCount(j) == num);
    }

    private int getCount(int x) {
        int count = 0;
        while (x != 0) {
            if (x % 2 != 0) {
                count++;
            }
            x = x >> 1;
        }
        return count;
    }
}
