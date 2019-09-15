/**
 * Created by xuanmao on 2019/5/21.
 */
public class leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] needLetter = new int[26];
        for (int i=0;i<ransomNote.length();i++){
            needLetter[ransomNote.charAt(i) - 'a'] ++;
        }
        for (int i=0;i<magazine.length();i++){
            needLetter[magazine.charAt(i) - 'a'] --;
        }
        for (int i=0;i<26;i++){
            if (needLetter[i]>0){
                return false;
            }
        }
        return true;
    }
}
