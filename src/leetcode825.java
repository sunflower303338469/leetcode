/**
 * Created by xuanmao on 2019/7/23.
 */
public class leetcode825 {
    public int numFriendRequests(int[] ages) {
        int[] friend = new int[140];
        int[] p = new int[140];
        int ans = 0;
        for (int i =0;i<ages.length;i++){
            p[ages[i]] ++;
            int t = ages[i]/2 + 7 - 1;
            if (t>ages[i]){
                ans++;
                continue;
            }
            if ((t>100) && (ages[i]<100)){
                continue;
            }
            friend[t] ++;
            friend[ages[i]+1] -- ;
        }
        int nowf = 0;
        for (int i=1;i<140;i++){
            nowf = nowf + friend[i];
            if (p[i]>0){
                System.out.println(i+" "+ nowf+ " "+ p[i]);
                ans = ans + p[i] * nowf;
            }
        }
        return ans - ages.length;
    }
}
