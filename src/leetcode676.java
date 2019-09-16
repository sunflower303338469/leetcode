/**
 * Created by xuanmao on 2019/8/18.
 */
public class leetcode676 {
    class MagicDictionary {

        String[] dict = null;
        /** Initialize your data structure here. */
        public MagicDictionary() {

        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            this.dict = dict;
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            for (int i=0;i<dict.length;i++){
                String matchStr=  dict[i];
                if (word.length()!=matchStr.length()){
                    continue;
                }
                if (word.equals(matchStr)){
                    continue;
                }
                int count = 0;
                for (int j=0;j<word.length();j++){
                    if (word.charAt(j)!=matchStr.charAt(j)){
                        count ++;
                    }
                }
                if (count==1){
                    return true;
                }
            }
            return false;
        }
    }
}
