/**
 * Created by xuanmao on 2020/9/2.
 */
public class leetcode806 {
    public int[] numberOfLines(int[] widths, String S) {
        int page = 1;
        int num = 0;
        for (int i  =0;i<S.length();i++){
            int index = S.charAt(i) - 'a';
            if (num+widths[index]>100){
                page++;
                num = widths[index];
            } else {
                num +=widths[index];
            }
        }
        int[] ans = new int[2];
        ans[0] = page;
        ans[1] = num;
        return ans;
    }
}
