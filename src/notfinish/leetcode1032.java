package notfinish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/4/21.
 */
public class leetcode1032 {
    class StreamChecker {
        private Map<Character, List<Integer>> map = new HashMap<>();
        private List<String> list = new ArrayList<>();
        private String now = "";
        private Map<String, Boolean> isOk = new HashMap<>();

        public StreamChecker(String[] words) {
            for (int i = 0; i < words.length; i++) {
                list.add(words[i]);
                isOk.put(words[i], true);
                char key = words[i].charAt(words[i].length() - 1);
                if (map.containsKey(key)) {
                    List<Integer> tempList = map.get(key);
                    tempList.add(i);
                    map.put(key, tempList);
                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    map.put(key, tempList);
                }
            }
        }

        public boolean query(char letter) {
            now = now + letter;

            if (map.containsKey(letter)) {
                List<Integer> wordList = map.get(letter);
                for (int i = 0; i < wordList.size(); i++) {
                    String word = list.get(wordList.get(i));
                    int h = word.length();
                    if ((h <= now.length()) && (isOk.containsKey(now.substring(now.length() - h)))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
