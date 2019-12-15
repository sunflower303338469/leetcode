import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2019/10/14.
 */
public class leetcode756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> allowMap = new HashMap<>();
        for (String allow : allowed) {
            Set<Character> clist = allowMap.getOrDefault(allow.substring(0, 2), new HashSet<>());
            clist.add(allow.charAt(2));
            allowMap.put(allow.substring(0, 2), clist);
        }
        List<Set<Character>> allowSetList = new ArrayList<>();
        for (int i=0;i<bottom.length()-1;i++){
            allowSetList.add(allowMap.getOrDefault(bottom.substring(i, i+2), new HashSet<>()));
        }
        int h = bottom.length()-1;
        while (h>1){
            for (int i=0;i<h-1;i++){
                Set<Character> temp = new HashSet<>();
                for (Character a:allowSetList.get(i)){
                    for (Character b:allowSetList.get(i+1)){
                        String sb = ""+a+b;
                        temp.addAll(allowMap.getOrDefault(sb, new HashSet<>()));
                    }
                }
                allowSetList.set(i, temp);
            }
            h--;
        }
        return !allowSetList.get(0).isEmpty();
    }
}
