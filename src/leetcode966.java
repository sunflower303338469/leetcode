import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2019/11/5.
 */
public class leetcode966 {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String , Integer> indexMap = new HashMap<>();
        Set<String> origin = new HashSet<>();
        Map<String, Integer> caseMap = new HashMap<>();
        for (int i =0;i<wordlist.length;i++){
            origin.add(wordlist[i]);
            String smallLetter =  wordlist[i].toLowerCase();
            if (!caseMap.containsKey(smallLetter)){
                caseMap.put(smallLetter, i);
            }
            String s = convert(wordlist[i]);
            if (!indexMap.containsKey(s)){
                indexMap.put(s, i);
            }
        }
        String[] ans = new String[queries.length];
        for (int i =0;i<queries.length;i++){
            if (origin.contains(queries[i])){
                ans[i] = queries[i];
            } else if (caseMap.containsKey(queries[i].toLowerCase())){
                ans[i] = wordlist[caseMap.get(queries[i].toLowerCase())];
            }
            else {
                Integer index=  indexMap.get(convert(queries[i]));
                if (index!=null){
                    ans[i]= wordlist[index];
                } else {
                    ans[i] = "";
                }
            }
        }
        return ans;
    }

    private String convert(String old){
        StringBuilder sb = new StringBuilder();
        char[] vowels = {'a', 'e' , 'i', 'o', 'u'};
        old = old.toLowerCase();
        for (int i=0;i<old.length();i++){
            boolean isVowel = false;
            for (int j = 0;j<vowels.length;j++){
                if (old.charAt(i) == vowels[j]){
                    isVowel = true;
                    sb.append('a');
                }
            }
            if (!isVowel){
                sb.append(old.charAt(i));
            }
        }
        return sb.toString();
    }
}
