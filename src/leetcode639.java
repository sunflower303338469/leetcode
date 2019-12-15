/**
 * Created by xuanmao on 2019/10/7.
 */
public class leetcode639 {
    public int numDecodings(String s) {
        long a;
        long b = 1;
        int mod = 1000000007;
        if (s.length()==0){
            return 0;
        }
        if (s.length()==1){
            if (s.charAt(0) == '*'){
                return 9;
            }
            if (s.charAt(0)=='0'){
                return 0;
            }
            return 1;
        }
        if (s.charAt(0)=='0'){
            return 0;
        }
        long c = 0;
        a = s.charAt(0)=='*'?9:1;
        for (int i =1;i<s.length();i++){
            if (s.charAt(i)=='*'){
                c = (a*9) % mod;
                if (s.charAt(i-1) == '1'){
                    c = (c+(b*9) % mod) % mod;
                }
                if (s.charAt(i-1) == '2'){
                    c = (c+(b*6) % mod) % mod;
                }
                if (s.charAt(i-1) == '*'){
                    c = (c+(b*15) % mod) % mod;
                }
            } else {
                if (s.charAt(i)=='0'){
                    if ((s.charAt(i-1) !='*') && (s.charAt(i-1)>'2')){
                        return 0;
                    }
                    c = 0;
                } else {
                    c = a;
                }
                if (s.charAt(i-1) == '1'){
                    c = (c+b) % mod;
                }
                if (s.charAt(i-1) == '2'){
                    if (s.charAt(i)<'7'){
                        c = (c+b) % mod;
                    }
                }
                if (s.charAt(i-1) == '*'){
                    c = (c+b) % mod;
                    if (s.charAt(i)<'7'){
                        c = (c+b) % mod;
                    }
                }
            }
            b = a;
            a = c;
        }
        return (int)a;
    }
}
