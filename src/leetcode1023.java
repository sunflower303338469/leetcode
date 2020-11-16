import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/24.
 */
public class leetcode1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans =new ArrayList<>();
        for (int  i=0;i<queries.length;i++){
            String s = queries[i];
            int index = 0;
            boolean now = false;
            for (int j  =0;j<s.length();j++){
                if ((index<pattern.length()) && (s.charAt(j)==pattern.charAt(index))){
                    index++;
                    if (index == pattern.length()){
                        now = true;
                    }
                    continue;
                }
                if ((s.charAt(j) >='A') && (s.charAt(j)<='Z')){
                    now = false;
                    break;
                }
            }
            ans.add(now);
        }
        return ans;
    }
}
