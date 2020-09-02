import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/7/10.
 */
public class leetcode1040 {
    public int[] numMovesStonesII(int[] stones) {
        int max = 0;
        int count = 0;
        int emptyCount = 0;
        List<Integer> stoneList = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            stoneList.add(stones[i]);
        }
        stoneList.sort(Comparator.naturalOrder());
        for (int i = 0; i < stoneList.size() - 1; i++) {
            max = max + stoneList.get(i + 1) - stoneList.get(i) - 1;
            if (stoneList.get(i + 1) - stoneList.get(i) - 1 > 0) {
                emptyCount++;
            }
        }
        max = max - Math.min(stoneList.get(1) - stoneList.get(0) - 1, stoneList.get(stoneList.size() - 1) - stoneList.get(stoneList.size() - 2) - 1);

        int index = 0;
        for (int i = 0; i < stoneList.size(); i++) {
            while (stoneList.get(i) - stoneList.get(index) > stoneList.size()) {
                index++;
            }
            count = Math.max(count, i - index + 1);
        }


        int[] ans = new int[2];
        if (emptyCount == 1) {
            for (int i = 0; i < stoneList.size() - 1; i++) {
                int empty = stoneList.get(i + 1) - stoneList.get(i) - 1;
                if (empty > 0) {
                    if (empty == 1) {
                        ans[0] = 1;
                    } else {
                        ans[0] = 2;
                    }
                }
            }
        } else {
            ans[0] = stones.length - count;
        }
        ans[1] = max;
        return ans;
    }
}
