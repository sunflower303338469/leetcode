import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/4/5.
 */
public class leetcode953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Character> map = new HashMap<>();
        for (int i=0;i<order.length();i++){
            map.put(order.charAt(i), (char)('a'+i));
        }
        for (int i=0;i<words.length-1;i++){
            StringBuilder word1 = new StringBuilder();
            StringBuilder word2 = new StringBuilder();
            for (int j=0;j<words[i].length();j++){
                word1.append(map.get(words[i].charAt(j)));
            }
            for (int j=0;j<words[i+1].length();j++){
                word2.append(map.get(words[i+1].charAt(j)));
            }
            if (word1.toString().compareTo(word2.toString())>0){
                return false;
            }
        }
        return true;
    }
}
