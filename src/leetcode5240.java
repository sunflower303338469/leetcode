import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/10/27.
 */
public class leetcode5240 {
    int max = 0;
    List<String> strList = new ArrayList<>();
    public int maxLength(List<String> arr) {
        strList = arr;
        find(0, "");
        return max;
    }

    private void find(int index, String s){
        if (s.length()>max){
            max = s.length();
        }
        for (int i=index;i<strList.size();i++){
            if (check(s, strList.get(i))){
                find(i+1, s+strList.get(i));
            }
        }
    }

    private boolean check(String s1, String s2){
        if (s1.length()+s2.length()>26){
            return false;
        }
        int[] v = new int[26];
        for (int i =0;i<s1.length();i++){
            v[s1.charAt(i)-'a']++;
        }
        for (int i =0;i<s2.length();i++){
            v[s2.charAt(i)-'a']++;
        }
        for (int i =0;i<26;i++){
            if (v[i]>=2){
                return false;
            }
        }
        return true;
    }
}
