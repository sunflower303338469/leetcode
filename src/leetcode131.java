import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/16.
 */
public class leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> all = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            String subString = s.substring(0,i+1);
            if (checkPalindrome(subString)){
                if (i+1==s.length()){
                    List<String> ans = new ArrayList<>();
                    ans.add(subString);
                    all.add(ans);
                } else {
                    List<List<String>> left = partition(s.substring(i+1));
                    for (List<String> leftList:left){
                        List<String> ans = new ArrayList<>();
                        ans.add(subString);
                        ans.addAll(leftList);
                        all.add(ans);
                    }
                }

            }
        }
        return all;
    }

    private boolean checkPalindrome(String s){
        for (int i =0;i<s.length()/2;i++){
            if (!(s.charAt(i) == s.charAt(s.length()-1-i))){
                return false;
            }
        }
        return true;
    }
}
