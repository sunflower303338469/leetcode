import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/8/26.
 */
public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (int i =0;i<strs.length;i++){
            int[] charList = new int[26];
            for (int j =0;j<strs[i].length();j++){
                charList[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb=  new StringBuilder();
            for (int j=0;j<26;j++){
                sb.append("|");
                sb.append(charList[j]);
            }
            List<String> stringList = anagramsMap.get(sb.toString());
            if (stringList == null){
                stringList = new ArrayList<>();
            }
            stringList.add(strs[i]);
            anagramsMap.put(sb.toString(), stringList);
        }
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(anagramsMap.values());
        return ans;
    }
}
