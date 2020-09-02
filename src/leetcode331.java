/**
 * Created by xuanmao on 2020/6/11.
 */
public class leetcode331 {
    private static final String LEAF = "#";

    public boolean isValidSerialization(String preorder) {
        String[] slist = preorder.split(",");
        int count = 1;
        for (String s : slist) {
            count--;
            if (count < 0) {
                return false;
            }
            if (!LEAF.equals(s)) {
                count += 2;
            }
        }
        return count == 0;
    }
}
