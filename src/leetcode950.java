import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/4.
 */
public class leetcode950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        List<Integer> numberList = new ArrayList<>();
        List<Integer> testList = new LinkedList<>();
        List<Integer> orderList = new ArrayList<>();
        int[] ans = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            numberList.add(deck[i]);
            testList.add(i);
        }
        numberList.sort(Comparator.naturalOrder());
        while (!testList.isEmpty()) {
            orderList.add(testList.get(0));
            testList.remove(0);
            if (!testList.isEmpty()) {
                Integer v = testList.remove(0);
                testList.add(v);
            }
        }
        for (int i =0;i< deck.length;i++){
            int index = orderList.get(i);
            ans[index] = numberList.get(i);
        }
        return ans;
    }
}
