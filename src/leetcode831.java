/**
 * Created by xuanmao on 2020/2/19.
 */
public class leetcode831 {
    public String maskPII(String S) {
        StringBuilder ans = new StringBuilder();
        if (S.contains("@")){
            S = S.toLowerCase();
            String[] sp = S.split("@");
            ans.append(sp[0].charAt(0));
            ans.append("*****");
            ans.append(sp[0].charAt(sp[0].length()-1));
            ans.append("@");
            ans.append(sp[1]);
        } else {
            S = S.replace("(","").replace(")","").replace(" ","").replace("+","").replace("-","");
            if (S.length()>10){
                ans.append("+");
                for (int i=10;i<S.length();i++){
                    ans.append("*");
                }
                ans.append("-");
            }
            ans.append("***-***-");
            ans.append(S.substring(S.length()-4));
        }
        return ans.toString();

    }
}
