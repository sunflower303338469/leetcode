import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xuanmao on 2020/2/12.
 */
public class leetcode804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] w = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> ansSet = new HashSet<>();
        for (int i =0;i<words.length;i++){
            StringBuilder sb=  new StringBuilder();
            for (int j =0;j<words[i].length();j++){
                sb.append(w[words[i].charAt(j)-'a']);
            }
            ansSet.add(sb.toString());
        }
        return ansSet.size();
    }
}
