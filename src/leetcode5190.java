/**
 * Created by xuanmao on 2019/9/15.
 */
public class leetcode5190 {
    boolean[] tag;
    public String reverseParentheses(String s) {
        tag = new boolean[s.length()];
        return getRev(s, false);

    }

    public String getRev(String s, boolean rev){
        String ans = "";
        for (int i=0;i<s.length();i++){
            if (tag[i]){
                continue;
            } else {
                tag[i] = true;
            }
            if (s.charAt(i)=='('){
                if (rev){
                    System.out.println(i+ " r "+ ans);
                    ans = getRev(s, !rev)+ans;
                }
                else{
                    System.out.println(i+ "  "+ ans);
                    ans = ans+getRev(s,!rev);
                }
            } else if (s.charAt(i)==')'){
                return ans;
            } else {
                if (rev){
                    ans = s.charAt(i)+ans;
                }
                else{
                    ans = ans+s.charAt(i);
                }
            }
        }
        return ans;
    }
}
