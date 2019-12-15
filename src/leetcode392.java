/**
 * Created by xuanmao on 2019/11/21.
 */
public class leetcode392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length()==0){
            return true;
        }
        int index=0;
        for (int i =0;i<t.length();i++){
            if (s.charAt(index) == t.charAt(i)){
                index++;
            }
            if (index>=s.length()){
                return true;
            }
        }
        return false;
    }
}
