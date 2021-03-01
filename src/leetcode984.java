/**
 * Created by xuanmao on 2021/2/19.
 */
public class leetcode984 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        Integer l1 = null;
        Integer l2 = null;
        while (a > 0 || b > 0) {
            if (a > b) {
                if (l1 != null && l2 != null && l1 == 1 && l2 == 1) {
                    sb.append("b");
                    b--;
                    l1 = l2;
                    l2 = 2;
                } else {
                    sb.append("a");
                    a--;
                    l1 = l2;
                    l2 = 1;
                }
            } else {
                if (l1 != null && l2 != null && l1 == 2 && l2 == 2) {
                    sb.append("a");
                    a--;
                    l1 = l2;
                    l2 = 1;
                } else {
                    sb.append("b");
                    b--;
                    l1 = l2;
                    l2 = 2;
                }
            }
        }
        return sb.toString();
    }
}
