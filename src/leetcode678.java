/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode678 {
    public boolean checkValidString(String s) {
        int star = 0;
        int count = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='*'){
                star++;
            }
            if (s.charAt(i)=='('){
                count++;
            }
            if (s.charAt(i)==')'){
                if (count >0){
                    count--;
                } else if (star>0){
                    star--;
                } else {
                    return false;
                }
            }
        }
        star = 0;
        count = 0;
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)=='*'){
                star++;
            }
            if (s.charAt(i)==')'){
                count++;
            }
            if (s.charAt(i)=='('){
                if (count >0){
                    count--;
                } else if (star>0){
                    star--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
