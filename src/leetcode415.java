/**
 * Created by xuanmao on 2019/2/24.
 */
public class leetcode415 {
    public String addStrings(String num1, String num2) {
        String renum1 = reverseStr(num1);
        String renum2 = reverseStr(num2);
        String reans = "";
        int h = 0;
        int k = 0;
        while ((h<renum1.length()) || (h<renum2.length()) || (k!=0)){
            int p = k;
            if (h<renum1.length()){
                p =p+renum1.charAt(h)-'0';
            }
            if (h<renum2.length()){
                p = p + renum2.charAt(h)-'0';
            }
            k = p / 10;
            p = p % 10;
            reans = reans + p;
            h = h +1;
        }
        if (reans.length() ==0){
            reans = "0";
        }
        return reverseStr(reans);
    }

    private String reverseStr(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }
}
