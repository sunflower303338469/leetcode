/**
 * Created by xuanmao on 2020/11/17.
 */
public class leetcode6 {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int k = numRows+numRows-2;
        for (int i=0;i<numRows;i++){
            boolean flag = true;
            for (int j=i;j<s.length();){
                ans.append(s.charAt(j));
                if ((i==0)||(i==numRows-1)){
                    j+=k;
                } else {
                    if (flag){
                        j+= (k-i*2);
                    } else {
                        j+=(i*2);
                    }
                }
                flag = !flag;
            }
        }


        return ans.toString();
    }
}
