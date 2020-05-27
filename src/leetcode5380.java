import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/4/12.
 */
public class leetcode5380 {
    public List<String> stringMatching(String[] words) {

        HashSet<String> set = new HashSet<>();
        for (int i =0;i<words.length;i++){
            for (int j=0;j<words.length;j++){
                if( (i!=j) && (check(words[i],words[j]))){
                    set.add(words[j]);
                }
            }
        }
        return set.stream().collect(Collectors.toList());
    }

    private boolean check(String a, String b){
        if (a.length()<=b.length()){
            return false;
        }
        for (int i=0;i<a.length();i++){
            int j  = i+b.length();
            if (j>a.length()){
                break;
            }
            if (a.substring(i,j).equals(b)){
                return true;
            }
        }
        return false;
    }
}
