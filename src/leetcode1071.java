/**
 * Created by xuanmao on 2019/6/2.
 */
public class leetcode1071 {
    public String gcdOfStrings(String str1, String str2) {
        String ans = "";
        for (int i=0;i<str1.length();i++){
            if ((str1.length()%(i+1) == 0) && (str2.length()%(i+1) ==0)) {
                System.out.println(i+1);
                String chushu = str1.substring(0,i+1);
                int l = str1.length()/(i+1);
                int r = str2.length()/(i+1);
                StringBuilder sb = new StringBuilder();
                String p1= "";
                String p2 = "";
                for (int j=0;j<l;j++){
                    p1 = p1+chushu;
                }
                for (int j=0;j<r;j++){
                    p2 = p2+chushu;
                }
                if ((p1.equals(str1)) && (p2.equals(str2))){
                    ans = chushu;
                }
            }
        }
        return ans;
    }
}
