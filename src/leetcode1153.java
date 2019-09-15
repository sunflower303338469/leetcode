import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode1153 {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> m = new HashMap<>();
        Set<Character> check = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            Character c = str1.charAt(i);
            check.add(str2.charAt(i));
            Character temp = m.get(c);
            if (temp == null) {
                m.put(c, str2.charAt(i));
            } else {
                if (!temp.equals(str2.charAt(i))) {
                    return false;
                }
            }
        }
        if (check.size() < 26) {
            return true;
        }
        int[] rudu = new int[26];
        boolean[] visit = new boolean[26];
        for (Character c : m.keySet()) {
            rudu[m.get(c) - 'a']++;
        }
        boolean p = true;
        while (p) {
            p = false;
            for (int i = 0; i < 26; i++) {
                if ((rudu[i] <= 0) && (!visit[i])) {
                    visit[i] = true;
                    if (m.containsKey((char) ('a' + i))) {
                        rudu[m.get((char) ('a' + i)) - 'a']--;
                        p = true;
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (rudu[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
