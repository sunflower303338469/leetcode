/**
 * Created by xuanmao on 2020/11/15.
 */
public class leetcode402 {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while ((sb.length() > 0) && (sb.charAt(sb.length() - 1) > num.charAt(i)) && (k > 0)) {
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb.length() > 0 || num.charAt(i) != '0') {
                sb.append(num.charAt(i));
            }
        }
        String ans = sb.toString();
        ans = ans.substring(0, ans.length() - k);
        return ans.length()==0?"0":ans;
    }
}
