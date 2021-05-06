/**
 * Created by xuanmao on 2021/5/4.
 */
public class leetcode621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int sum = 0;
        for (int i =0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
        }
        int max = 0;
        int num = 0;
        for (int i=0;i<26;i++){
            sum = sum+count[i];
            if (count[i]>max){
                max = count[i];
                num = 1;
            } else if (count[i] == max){
                num++;
            }
        }
        return Math.max(sum, (max-1)*(n+1)+num);
    }
}
