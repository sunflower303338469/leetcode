import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/5/23.
 */
public class leetcode809 {
    class CharTag {
        public char c;
        public int num;
    }

    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        List<CharTag> sTag = getCharList(S);
        for (int i = 0; i < words.length; i++) {
            List<CharTag> wordsTag = getCharList(words[i]);
            if (wordsTag.size() == sTag.size()) {
                boolean isExpressive = true;
                for (int j = 0; j < sTag.size(); j++) {
                    if (sTag.get(j).c != wordsTag.get(j).c) {
                        isExpressive = false;
                    }
                    if ((sTag.get(j).num < wordsTag.get(j).num) || ((sTag.get(j).num == 2) && (wordsTag.get(j).num == 1))) {
                        isExpressive = false;
                    }
                }
                if (isExpressive) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private List<CharTag> getCharList(String s) {
        List<CharTag> charList = new ArrayList<>();
        CharTag nowTag = new CharTag();
        for (int i = 0; i < s.length(); i++) {
            if (nowTag.c == 0) {
                nowTag.c = s.charAt(i);
                nowTag.num = 1;
            } else if (nowTag.c == s.charAt(i)) {
                nowTag.num += 1;
            } else {
                charList.add(nowTag);
                nowTag = new CharTag();
                nowTag.c = s.charAt(i);
                nowTag.num = 1;
            }
        }
        if (nowTag.c != 0) {
            charList.add(nowTag);
        }
        return charList;
    }
}
"dddiiiinnssssssoooo"
        ["dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"]