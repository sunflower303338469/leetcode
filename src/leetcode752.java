import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanmao on 2020/7/9.
 */
public class leetcode752 {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> visitSet = new HashSet<>();
        for (String dead : deadends) {
            visitSet.add(dead);
        }
        if (visitSet.contains("0000")) {
            return -1;
        }
        List<String> valueList = new ArrayList<>();
        valueList.add("0000");
        visitSet.add("0000");
        List<Integer> countList = new ArrayList<>();
        countList.add(0);

        int l = 0;
        while (l < valueList.size()) {
            String now = valueList.get(l);
            Integer c = countList.get(l);
            StringBuilder sb = new StringBuilder(now);
            System.out.println(now);

            for (int i = 0; i < now.length(); i++) {
                int value = now.charAt(i) - '0';
                sb.setCharAt(i, (char) ('0' + (value + 1) % 10));
                if (sb.toString().equals(target)) {
                    return c + 1;
                }
                if (!visitSet.contains(sb.toString())) {
                    visitSet.add(sb.toString());
                    valueList.add(sb.toString());
                    countList.add(c + 1);
                }

                sb.setCharAt(i, (char) ('0' + (value - 1 + 10) % 10));
                if (sb.toString().equals(target)) {
                    return c + 1;
                }
                if (!visitSet.contains(sb.toString())) {
                    visitSet.add(sb.toString());
                    valueList.add(sb.toString());
                    countList.add(c + 1);
                }
                sb.setCharAt(i, now.charAt(i));
            }

            l++;
        }

        return -1;
    }
}
