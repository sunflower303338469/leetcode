/**
 * Created by xuanmao on 2020/6/9.
 */
public class leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0) {
            return sb.toString();
        }
        for (int k = 0; k < strs[0].length(); k++) {
            for (int i = 1; i < strs.length; i++) {
                if ((strs[i].length() <= k) || (strs[i].charAt(k) != strs[0].charAt(k))) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(k));
        }
        return sb.toString();
    }
}
