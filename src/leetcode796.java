/**
 * Created by xuanmao on 2020/2/24.
 */
public class leetcode796 {
    public boolean rotateString(String A, String B) {
        if ((A.length()==0) && (B.length()==0)){
            return true;
        }
        if (A.length()!=B.length()){
            return false;
        }
        B = B+B;
        for (int j=0;j<B.length();j++){
            if (j+A.length()>B.length()){
                break;
            }
            boolean flag = true;
            for (int i =0;i<A.length();i++){
                if (A.charAt(i)!=B.charAt(j+i)){
                    flag = false;
                }
            }
            if (flag){
                return true;
            }
        }
        return false;
    }
}
