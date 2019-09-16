import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/15.
 */
public class leetcode824 {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] strList=  S.split(" ");
        StringBuilder postfix = new StringBuilder();
        List<Character> yuanyin = new ArrayList<>();
        yuanyin.add('a');yuanyin.add('e');yuanyin.add('i');yuanyin.add('o');yuanyin.add('u');
        yuanyin.add('A');yuanyin.add('E');yuanyin.add('I');yuanyin.add('O');yuanyin.add('U');
        for (int i =0;i<strList.length;i++){
            String word= strList[i];
            Character first = word.charAt(0);
            if (yuanyin.contains(first)){
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }
            sb.append("ma");
            postfix.append("a");
            sb.append(postfix);
            if (i!=strList.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
