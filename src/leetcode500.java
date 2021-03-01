import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/11/19.
 */
public class leetcode500 {
    int[] match = {1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};

    public String[] findWords(String[] words) {
        List<String> ansList = new ArrayList<>();
        for (String s:words){
            if (check(s.toLowerCase())){
                ansList.add(s);
            }
        }
        String[] ans = new String[ansList.size()];
        for(int i =0;i<ansList.size();i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    private boolean check(String s){
        if (s.length()==0){
            return true;
        }
        int index = match[s.charAt(0)-'a'];
        for (int i =1;i<s.length();i++){
            if (index!=match[s.charAt(i)-'a']){
                return false;
            }
        }
        return true;
    }
}
