/**
 * Created by xuanmao on 2021/3/22.
 */
public class leetcode1737 {
    public int minCharacters(String a, String b) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (int i =0;i<a.length();i++){
            f1[a.charAt(i)-'a']++;
        }
        for (int i =0;i<b.length();i++){
            f2[b.charAt(i)-'a']++;
        }
        int ans = a.length()+b.length()-f1[0]-f2[0];
        for (int i=1;i<26;i++){
            ans = Math.min(ans, a.length()+b.length()-f1[i]-f2[i]);
            f1[i] = f1[i-1]+f1[i];
            f2[i] = f2[i-1]+f2[i];
        }
        for (int i=1;i<26;i++){
            int value1 = (a.length()-f1[i-1])+ f2[i-1];
            ans = Math.min(ans, value1);
            int value2 = (b.length()-f2[i-1])+ f1[i-1];
            ans = Math.min(ans, value2);
        }
        return ans;
    }
}
