/**
 * Created by xuanmao on 2020/10/6.
 */
public class leetcode925 {
    public boolean isLongPressedName(String name, String typed) {
        int index = 0;
        for (int i = 0; i < typed.length(); i++) {
            if ((index < name.length()) && (typed.charAt(i) == name.charAt(index))) {
                index++;
            } else {
                if ((i == 0) || (typed.charAt(i) != typed.charAt(i - 1))) {
                    return false;
                }
            }
        }
        return index == name.length();
    }
}
