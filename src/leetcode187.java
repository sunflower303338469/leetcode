import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/6/2.
 */
public class leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> ansSet = new HashSet<>();
        HashSet<String> containSet = new HashSet<>();
        for (int i =0;i<=s.length()-10;i++){
            String subStr = s.substring(i, i+10);
            if (containSet.contains(subStr)){
                ansSet.add(subStr);
            } else {
                containSet.add(subStr);
            }
        }
        return ansSet.stream().collect(Collectors.toList());
    }
}
