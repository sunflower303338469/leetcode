import java.util.HashSet;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/11.
 */
public class leetcode1436 {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set=  new HashSet<>();
        for (List<String> path:paths){
            set.add(path.get(1));
        }
        for (List<String> path:paths){
            set.remove(path.get(0));
        }
        for (String s:set){
            return s;
        }
        return null;
    }
}
