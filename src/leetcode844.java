/**
 * Created by xuanmao on 2020/10/19.
 */
public class leetcode844 {
    public boolean backspaceCompare(String S, String T) {
        return getValue(S).equals(getValue(T));
    }

    private String getValue(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
