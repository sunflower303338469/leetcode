import java.util.HashSet;

/**
 * Created by xuanmao on 2020/9/24.
 */
public class leetcode884 {
    public String[] uncommonFromSentences(String A, String B) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> ansSet = new HashSet<>();
        String[] aList= A.split(" ");
        String[] bList = B.split(" ");
        for (int i =0;i<aList.length;i++){
            if (set.contains(aList[i])){
                ansSet.remove(aList[i]);
            } else {
                set.add(aList[i]);
                ansSet.add(aList[i]);
            }
        }
        for (int i=0;i<bList.length;i++){
            if (set.contains(bList[i])){
                ansSet.remove(bList[i]);
            } else {
                set.add(bList[i]);
                ansSet.add(bList[i]);
            }
        }
        String[] ans = new String[ansSet.size()];
        int i = 0;
        for (String s:ansSet){
            ans[i] = s;
            i++;
        }
        return ans;
    }
}
