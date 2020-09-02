import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/8/27.
 */
public class leetcode17 {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            Character c = digits.charAt(i);
            List<String> next = new ArrayList<>();
            switch (c) {
                case '2':
                    for (Character chr = 'a';chr<='c';chr++){
                        for (String old:ans){
                            String newStr = old + chr;
                            next.add(newStr);
                        }
                    }
                    break;
                case '3':
                    for (Character chr = 'd';chr<='f';chr++){
                        for (String old:ans){
                            String newStr = old + chr;
                            next.add(newStr);
                        }
                    }
                    break;
                case '4':
                    for (Character chr = 'g';chr<='i';chr++){
                        for (String old:ans){
                            String newStr = old + chr;
                            next.add(newStr);
                        }
                    }
                    break;
                case '5':
                    for (Character chr = 'j';chr<='l';chr++){
                        for (String old:ans){
                            String newStr = old + chr;
                            next.add(newStr);
                        }
                    }
                    break;
                case '6':
                    for (Character chr = 'm';chr<='o';chr++){
                        for (String old:ans){
                            String newStr = old + chr;
                            next.add(newStr);
                        }
                    }
                    break;
                case '7':
                    for (Character chr = 'p';chr<='s';chr++){
                        for (String old:ans){
                            String newStr = old + chr;
                            next.add(newStr);
                        }
                    }
                    break;
                case '8':
                    for (Character chr = 't';chr<='v';chr++){
                        for (String old:ans){
                            String newStr = old + chr;
                            next.add(newStr);
                        }
                    }
                    break;
                case '9':
                    for (Character chr = 'w';chr<='z';chr++){
                        for (String old:ans){
                            String newStr = old + chr;
                            next.add(newStr);
                        }
                    }
                    break;
                default:
            }
            ans = next;
        }
        return ans;
    }
}
