/**
 * Created by xuanmao on 2020/4/10.
 */
public class leetcode151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] slist = s.split("\\s+");
        if (slist.length==0){
            return "";
        }
        StringBuilder sb= new StringBuilder();
        for (int i =slist.length-1;i>=1;i--){
            sb.append(slist[i]+ " ");
        }
        sb.append(slist[0]);
        return sb.toString();
    }
}
