/**
 * Created by xuanmao on 2019/8/18.
 */
public class leetcode299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i =0;i<secret.length();i++){
            count[secret.charAt(i)-'0']++;
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
        }
        for (int i=0;i<guess.length();i++){
            if (count[guess.charAt(i)-'0']>0){
                cows++;
                count[guess.charAt(i)-'0']--;
            }
        }
        cows -= bulls;
        return bulls+"A"+cows+"B";
    }
}
