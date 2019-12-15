import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/10/14.
 */
public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] a = new int[26];
        int[] b= new int[26];
        for (int i =0;i<p.length();i++){
            b[p.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
            if (i>=p.length()){
                a[s.charAt(i-p.length())-'a']--;
            }
            boolean flag =true;
            for (int j=0;j<26;j++){
                if (a[j]!=b[j]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                ans.add(i-p.length()+1);
            }
        }

        return ans;
    }
}
