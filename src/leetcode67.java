/**
 * Created by xuanmao on 2020/4/27.
 */
public class leetcode67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int jinwei = 0;
        while ((jinwei>0) || (a.length()>=i) || (b.length()>=i)) {
            int v1 = 0;
            if (a.length()>=i){
                v1 = a.charAt(a.length()-i)-'0';
            }
            int v2 = 0;
            if (b.length()>=i){
                v2 = b.charAt(b.length()-i)-'0';
            }
            jinwei = jinwei+v1+v2;
            sb.append(jinwei%2);
            jinwei = jinwei/2;
            i++;
        }
        return sb.reverse().toString();
    }
}
