/**
 * Created by xuanmao on 2020/6/9.
 */
public class leetcode1156 {
    public int maxRepOpt1(String text) {
        if (text.length()<=1){
            return text.length();
        }

        int[] counta = new int[text.length()];
        int[] countb = new int[text.length()];
        int[] num = new int[26];
        counta[0]= 1;
        num[text.charAt(0)-'a']++;
        countb[text.length()-1]=1;
        int ans = 1;
        for (int i=1;i<text.length();i++){
            if (text.charAt(i) == text.charAt(i-1)){
                counta[i] = counta[i-1]+1;
            } else {
                counta[i] = 1;
            }
            num[text.charAt(i)-'a']++;
        }

        for (int i=text.length()-2;i>=0;i--){
            if (text.charAt(i) == text.charAt(i+1)){
                countb[i] = countb[i+1]+1;
                ans = Math.max(ans, Math.min(countb[i]+1, num[text.charAt(i)-'a']));
            } else {
                countb[i] = 1;
            }
        }
        for (int i=1;i<text.length()-1;i++){
            if (text.charAt(i-1) == text.charAt(i+1)){
                ans= Math.max(ans, Math.min(counta[i-1]+countb[i+1]+1, num[text.charAt(i-1)-'a']));
                ans = Math.max(ans, counta[i-1]+countb[i+1]);
            }
        }

        return ans;
    }
}
