import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/2/18.
 */
public class leetcode830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        if ((S==null) || (S.length()==0)){
            return ans;
        }
        Character c = S.charAt(0);
        int count = 1;
        for (int i=1;i<S.length();i++){
            if (S.charAt(i)==c){
                count++;
            } else {
                if (count>=3){
                    List<Integer> largeGroup = new ArrayList<>();
                    largeGroup.add(i-count);
                    largeGroup.add(i-1);
                    ans.add(largeGroup);
                }
                c= S.charAt(i);
                count = 1;
            }
        }
        if (count>=3){
            List<Integer> largeGroup = new ArrayList<>();
            largeGroup.add(S.length()-count);
            largeGroup.add(S.length()-1);
            ans.add(largeGroup);
        }
        return ans;
    }
}
