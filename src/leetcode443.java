/**
 * Created by xuanmao on 2020/4/10.
 */
public class leetcode443 {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char c =' ';
        for (int i=0;i<chars.length;i++){
            if(chars[i]==c){
                count++;
            } else {
                if (count>1){
                    sb.append(count);
                }
                c = chars[i];
                count = 1;
                sb.append(c);
            }
        }
        if (count>1){
            sb.append(count);
        }
        String s = sb.toString();
        for (int i=0;i<s.length();i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}
