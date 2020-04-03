/**
 * Created by xuanmao on 2020/3/31.
 */
public class leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] match = new int[26];
        int[] before = new int[26];
        int[] after = new int[26];
        for (int i= 0;i<s1.length();i++){
            match[s1.charAt(i)-'a']++;
        }
        for (int i=0;i<s2.length();i++){
            after[s2.charAt(i)-'a']++;
            if (i>=s1.length()){
                before[s2.charAt(i-s1.length())-'a']++;
            }
            if (i>=s1.length()-1){
                if (check(before,after,match)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int[] before, int[] after, int[] match){
        for (int i =0;i<26;i++){
            if (match[i]!=after[i]-before[i]){
                return false;
            }
        }
        return true;
    }
}
