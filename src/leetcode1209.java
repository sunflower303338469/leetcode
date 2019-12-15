/**
 * Created by xuanmao on 2019/12/11.
 */
public class leetcode1209 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (flag){
            flag = false;
            int count = 0;
            for (int i =0;i<s.length();i++){
                sb.append(s.charAt(i));
                if ((i>0) && (s.charAt(i) == s.charAt(i-1))){
                    count++;
                } else {
                    count = 1;
                }
                if (count == k){
                    sb.delete(sb.length()-k, sb.length());
                    count =0;
                    flag = true;
                }
            }
            s = sb.toString();
            sb = new StringBuilder();
        }
        return s;
    }
}
