import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/4/9.
 */
public class leetcode22 {

    public List<String> generateParenthesis(int n) {

        return dfs(n).stream().collect(Collectors.toList());
    }

    Map<Integer, HashSet<String>> map = new HashMap<>();

    private HashSet<String> dfs(Integer n) {
        if (n == 0) {
            return new HashSet<>();
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        if (n == 1) {
            String s = "()";
            HashSet<String> set = new HashSet<>();
            set.add(s);
            map.put(n, set);
            return set;
        }
        HashSet<String> stringSet = new HashSet<>();
        for (int i =1;i<=n-1;i++){
            HashSet<String> left = dfs(i);
            HashSet<String> right = dfs(n-i);
            for (String l:left){
                for (String r:right){
                    String a = l+r;
                    stringSet.add(a);
                }
            }

        }

        HashSet<String> oldStringSet = dfs(n - 1);
        for (String oldString : oldStringSet) {
            stringSet.add("(" + oldString + ")");
        }
        map.put(n, stringSet);
        return stringSet;
    }
}
