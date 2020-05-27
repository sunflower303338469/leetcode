import java.util.HashSet;

/**
 * Created by xuanmao on 2020/4/12.
 */
public class leetcode929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (int i=0;i<emails.length;i++){
            String[] slist = emails[i].split("@");
            String s1 = slist[0].replace(".","").split("\\+")[0];
            String sfin = s1+"@"+slist[1];
            set.add(sfin);
        }
        return set.size();
    }
}
