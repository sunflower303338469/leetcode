/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode748 {
    int[] ch = new int[26];

    public String shortestCompletingWord(String licensePlate, String[] words) {
        for (int i =0;i<licensePlate.length();i++){
            if ((licensePlate.charAt(i)>='A') && (licensePlate.charAt(i)<='Z')){
                ch[licensePlate.charAt(i)-'A']++;
            }
            if ((licensePlate.charAt(i)>='a') && (licensePlate.charAt(i)<='z')){
                ch[licensePlate.charAt(i)-'a']++;
            }
        }
        String ans = null;
        int min = Integer.MAX_VALUE;
        for (String word:words){
            if (check(word)){
                if (word.length()<min){
                    min = word.length();
                    ans = word;
                }
            }
        }
        return ans;
    }

    private boolean check(String word){
        int[] c = new int[26];
        for (int i =0;i<word.length();i++) {
            if ((word.charAt(i) >= 'a') && (word.charAt(i) <= 'z')) {
                c[word.charAt(i) - 'a']++;
            }
        }
        for (int i =0;i<26;i++){
            if (ch[i]>c[i]){
                return false;
            }
        }
        return true;
    }
}
