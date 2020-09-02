/**
 * Created by xuanmao on 2020/8/13.
 */
public class leetcode1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length()!=t.length()){
            return false;
        }
        int[] count = new int[26];
        for (int i=0;i<26;i++){
            count[i]= k/26;
        }
        for (int i=0;i<k%26;i++){
            count[i]++;
        }
        for (int i =0;i<s.length();i++){
            int a = s.charAt(i)-'a';
            int b = t.charAt(i)-'a';
            if (a==b){
                continue;
            }
            int index = (b-a-1+26)% 26;
            System.out.println(index);
            count[index]--;
            if (count[index]<0){
                return false;
            }
        }
        return true;
    }
}
