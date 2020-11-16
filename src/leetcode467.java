/**
 * Created by xuanmao on 2020/11/3.
 */
public class leetcode467 {
    public int findSubstringInWraproundString(String p) {
        if (p.isEmpty()) {
            return 0;
        }
        int[] f = new int[p.length()];
        int[] count = new int[26];
        f[0] = 1;
        count[p.charAt(0)-'a']=1;
        int ans = 0;
        for (int i = 1; i < p.length(); i++) {
            f[i] = 1;
            if (((p.charAt(i-1)-'a'+1)%26) == p.charAt(i)-'a'){
                f[i] = f[i-1]+1;
            }
            count[p.charAt(i)-'a'] = Math.max(count[p.charAt(i)-'a'], f[i]);
        }
        for (int i =0;i<26;i++){
            ans +=count[i];
        }
        return ans;
    }
}
