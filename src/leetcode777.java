import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/11.
 */
public class leetcode777 {
    class Cha {
        Character c;
        Integer index;
    }

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        List<Cha> chaList = new ArrayList<>();
        for (int i=0;i<start.length();i++){
            if (start.charAt(i)!='X'){
                Cha cha = new Cha();
                cha.c = start.charAt(i);
                cha.index = i;
                chaList.add(cha);
            }
        }
        int pos = 0;
        for (int i=0;i<end.length();i++){
            if (end.charAt(i)!='X'){
                if (pos>=chaList.size()){
                    return false;
                }
                Cha cha = chaList.get(pos);
                if (cha.c != end.charAt(i)){
                    return false;
                }
                if ((cha.c=='L') && (cha.index<i)){
                    return false;
                }
                if ((cha.c=='R') && (cha.index>i)){
                    return false;
                }
                pos++;
            }
        }
        return pos == chaList.size();
    }
}
