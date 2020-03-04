import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode842 {
    List<Integer> ans = new ArrayList<>();
    int maxLength = 10;

    public List<Integer> splitIntoFibonacci(String S) {
        if (S.length() < 3) {
            return new ArrayList<>();
        }
        for (int i = 0; i < S.length() - 2; i++) {
            for (int j = i + 1; j < S.length() - 1; j++) {
                ans = new ArrayList<>();
                String s1 = S.substring(0, i + 1);
                String s2 = S.substring(i + 1, j + 1);
                if ((i + 1 > maxLength) || (j - i > maxLength)) {
                    continue;
                }
                Long v1 = Long.valueOf(s1);
                Long v2 = Long.valueOf(s2);
                if ((v1 > Integer.MAX_VALUE) || (v2 > Integer.MAX_VALUE)) {
                    continue;
                }
                ans.add(Integer.valueOf(s1));
                ans.add(Integer.valueOf(s2));
                if ((String.valueOf(ans.get(0)).equals(s1)) && (String.valueOf(ans.get(1)).equals(s2))) {
                    if (gocheck(S.substring(j + 1))) {
                        return ans;
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean gocheck(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i > maxLength) {
                break;
            }
            String temp = s.substring(0, i + 1);
            Long v = Long.valueOf(temp);
            if (v > Integer.MAX_VALUE) {
                break;
            }
            Integer value = Integer.valueOf(temp);
            if (!temp.equals(String.valueOf(value))) {
                continue;
            }
            if (value == ans.get(ans.size() - 1) + ans.get(ans.size() - 2)) {
                ans.add(value);
                if (i == s.length() - 1) {
                    return true;
                } else {
                    return gocheck(s.substring(i + 1));
                }
            }
        }
        return false;
    }
}
