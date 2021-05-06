/**
 * Created by xuanmao on 2021/5/5.
 */
public class leetcode1668 {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i =1;i<=100;i++){
            sb.append(word);
            if (sequence.contains(sb.toString())){
                ans = i;
            }
        }
        return ans;
    }
}
