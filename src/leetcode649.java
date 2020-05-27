/**
 * Created by xuanmao on 2020/4/14.
 */
public class leetcode649 {
    public String predictPartyVictory(String senate) {
        int r = 0;
        int d = 0;
        boolean[] f = new boolean[senate.length()];
        for (int i =0;i<senate.length();i++){
            if (senate.charAt(i)=='R'){
                r++;
            } else {
                d++;
            }
        }
        int now = 0;
        int delr = 0;
        int deld = 0;
        while ((r>0) && (d>0)){
            if (!f[now]){
                if (senate.charAt(now)=='R'){
                    if (deld>0){
                        deld--;
                        f[now] = true;
                        r--;
                    } else {
                        delr++;
                    }
                } else {
                    if (delr>0){
                        delr--;
                        f[now] = true;
                        d--;
                    } else {
                        deld++;
                    }
                }
            }
            now = (now+1) % f.length;
        }
        if (r==0){
            return "Dire";
        } else {
            return "Radiant";
        }
    }
}
