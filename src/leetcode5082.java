import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class leetcode5082 {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] value = new int[100][100];
        List<Integer> blocks = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                value[i % sideLength][j % sideLength]++;
            }
        }
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                blocks.add(value[i][j]);
            }
        }
        blocks.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer);
            }
        });
        int ans = 0;
        for (int i = 0; i < maxOnes; i++) {
            ans += blocks.get(i);
        }
        return ans;
    }
}
