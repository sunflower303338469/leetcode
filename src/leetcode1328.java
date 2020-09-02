/**
 * Created by xuanmao on 2020/8/11.
 */
public class leetcode1328 {
    public String breakPalindrome(String palindrome) {

        if (palindrome.length()<=1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i  =0;i<palindrome.length();i++){
            if ((palindrome.charAt(i)!='a') && (!( palindrome.length()%2!=0 && i==palindrome.length()/2)) && (!flag)){
                sb.append("a");
                flag = true;
            } else {
                sb.append(palindrome.charAt(i));
            }

        }
        if (!flag){
            sb.deleteCharAt(palindrome.length()-1);
            sb.append("b");
        }
        return sb.toString();
    }
}
