/**
 * Created by xuanmao on 2019/1/25.
 */
public class leetcode859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length()!= B.length()){
            return false;
        }
        int[] a = new int[26];
        int count = 0;
        int a1= 0,b1 =0 ,a2 = 0,b2 = 0;
        for (int i=0; i<A.length(); i++){
            if (A.charAt(i) != B.charAt(i)){
                count = count + 1;
                if (count >2 ){
                    return false;
                }
                if (count ==1){
                    a1 = A.charAt(i);
                    b1 = B.charAt(i);
                }
                if (count ==2 ){
                    a2 = A.charAt(i);
                    b2 = B.charAt(i);
                }

            }
            a[A.charAt(i) - 'a'] +=1;

        }
        if (count ==0){
            for (int i=0;i<26;i++){
                if (a[i]>=2){
                    return true;
                }
            }
        }
        if (count ==2){
            if ((a1 == b2 ) && (a2 == b1)){
                return true;
            }
        }
        return false;
    }
}
