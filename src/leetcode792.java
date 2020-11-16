import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/9/4.
 */
public class leetcode792 {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        int[] index = new int[words.length];
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> indexList = map.getOrDefault(words[i].charAt(0), new ArrayList<>());
            indexList.add(i);
            map.put(words[i].charAt(0), indexList);
        }
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            List<Integer> indexList = map.getOrDefault(c, new ArrayList<>());
            map.put(c, new ArrayList<>());
            for (Integer indexValue : indexList) {
                index[indexValue]++;
                if (index[indexValue] < words[indexValue].length()) {
                    List<Integer> tempList = map.getOrDefault(words[indexValue].charAt(index[indexValue]), new ArrayList<>());
                    tempList.add(indexValue);
                    map.put(words[indexValue].charAt(index[indexValue]), tempList);
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }
}
