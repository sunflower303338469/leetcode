/**
 * Created by xuanmao on 2019/6/9.
 */
public class leetcode5086 {
    public String smallestSubsequence(String text) {
        int [] letter = new int[26];
        boolean[] vis = new boolean[26];
        for (int i=0;i<text.length();i++){
            letter[(int)text.charAt(i)-(int)'a']++;
            vis[(int)text.charAt(i)-(int)'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<text.length();i++){
            if (vis[(int)text.charAt(i)-(int)'a']){
                while ((builder.length()>0) && (builder.charAt(builder.length()-1)>text.charAt(i)) && (letter[(int)builder.charAt(builder.length()-1)-(int)'a']>0)){
                    vis[(int)builder.charAt(builder.length()-1)-(int)'a'] = true;
                    builder.deleteCharAt(builder.length()-1);
                }
                vis[(int)text.charAt(i)-(int)'a'] = false;
                builder.append(text.charAt(i));
            }
            letter[(int)text.charAt(i)-(int)'a']--;
        }
        return builder.toString();
    }
}
