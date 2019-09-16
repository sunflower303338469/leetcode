import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/8/9.
 */
public class t1 {
    public int countCharacters(String[] words, String chars) {
        int[] charsNum = new int[26];
        int ans =0;
        for (int i =0;i<chars.length();i++){
            charsNum[chars.charAt(i)-'a']++;
        }
        for (int i=0;i<words.length;i++){
            boolean flag = true;
            int[] wordsNum = new int[26];
            for (int j=0;j<words[i].length();j++){
                wordsNum[words[i].charAt(j)-'a']++;
            }
            for (int j=0;j<26;j++){
                if (wordsNum[j]>charsNum[j]){
                    flag=false;
                }
            }
            if (flag){
                ans+=words[i].length();
            }
        }
        return ans;
    }
}
