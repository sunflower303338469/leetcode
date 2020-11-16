/**
 * Created by xuanmao on 2020/9/28.
 */
public class leetcode686 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int x = b.length()/a.length();
        if (b.length()%a.length()!=0){
            x++;
        }
        for (int i =1;i<=x;i++){
            sb.append(a);
        }
        if (sb.toString().contains(b)){
            return x;
        }
        sb.append(a);
        if (sb.toString().contains(b)){
            return x+1;
        }
        return -1;
    }
}
