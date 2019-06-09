import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/6/9.
 */
public class leetcode5083 {
    public String[] findOcurrences(String text, String first, String second) {
        String [] strList = text.split(" ");
        boolean flag = false;
        List<String> ans = new ArrayList<>();
        for (int i=0;i<strList.length;i++){
            if (strList[i].equals(first)){
                flag = true;
            } else {
                if ((flag) && (second.equals(strList[i]))){
                    if (i+1<strList.length){
                        ans.add(strList[i+1]);
                    }
                }
                flag = false;
            }
        }
        String[] a = new String[ans.size()];
        for (int i =0;i<ans.size();i++){
            a[i] = ans.get(i);
        }
        return a;
    }
}
