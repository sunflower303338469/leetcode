package interviewQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/9/4.
 */
public class interview16_02 {
    class WordsFrequency {

        Map<String, Integer> map = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (int i = 0; i < book.length; i++) {
                int count = map.getOrDefault(book[i], 0);
                count++;
                map.put(book[i], count);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }
}
