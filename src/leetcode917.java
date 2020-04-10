/**
 * Created by xuanmao on 2020/4/5.
 */
public class leetcode917 {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        int h = S.length()-1;
        for (int i =0;i<S.length();i++){
            if (!isLetter(S.charAt(i))){
                sb.append(S.charAt(i));
            } else {
                while (h>=0){
                    if (isLetter(S.charAt(h))){
                        sb.append(S.charAt(h));
                        h--;
                        break;
                    }
                    h--;
                }
            }
        }
        return sb.toString();
    }

    private boolean isLetter(char x){
        return ((x>='a') && (x<='z')) || ((x>='A') && (x<='Z'));
    }
}
