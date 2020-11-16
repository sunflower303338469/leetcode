package jianzhi;

/**
 * Created by xuanmao on 2020/9/10.
 */
public class jianzhi58 {
    public String reverseLeftWords(String s, int n) {
        if (n==0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=n;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        for (int i=0;i<n;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
