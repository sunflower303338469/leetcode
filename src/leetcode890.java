import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/6/18.
 */
public class leetcode890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (int i=0;i<words.length;i++){
            if (check(words[i], pattern)){
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean check(String a, String b){
        if (a.length()!=b.length()){
            return false;
        }
        int[] mapA = new int[27];
        int[] mapB = new int[27];
        for (int i=0;i<a.length();i++){
            int valueA = a.charAt(i)-'a'+1;
            int valueB = b.charAt(i)-'a'+1;
            if (mapA[valueA] == 0 && mapB[valueB] == 0){
                mapA[valueA] = valueB;
                mapB[valueB] = valueA;
            } else if (mapA[valueA] != valueB || mapB[valueB] !=valueA){
                return false;
            }
        }
        return true;
    }
}
