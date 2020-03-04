import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/2/18.
 */
public class leetcode937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> logList= new ArrayList<>();
        for (int i =0;i<logs.length;i++){
            logList.add(logs[i]);
        }
        logList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ",2);
                String[] s2 = o2.split(" ",2);
                if ((s1[1].charAt(0)>='0') && (s1[1].charAt(0)<='9')){
                    if ((s2[1].charAt(0)>='0') && (s2[1].charAt(0)<='9')){
                        System.out.println(o1+"///"+o2+"///-1");
                        return 0;
                    } else {
                        System.out.println(o1+"///"+o2+"///1");
                        return 1;
                    }
                }
                if ((s2[1].charAt(0)>='0') && (s2[1].charAt(0)<='9')){
                    return -1;
                }
                String string1 = "";
                String string2 = "";
                for (int i=1;i<s1.length;i++){
                    string1 = string1+s1[i];
                }
                for (int j=1;j<s2.length;j++){
                    string2 = string2+s2[j];
                }
                if (string1.equals(string2)){
                    return s1[0].compareTo(s2[0]);
                }
                return string1.compareTo(string2);
            }
        });
        String[] ans = new String[logs.length];
        for (int i=0;i<logs.length;i++){
            ans[i] = logList.get(i);
        }
        return ans;
    }
}
