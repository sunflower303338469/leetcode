/**
 * Created by xuanmao on 2020/9/3.
 */
public class leetcode820 {
    public int minimumLengthEncoding(String[] words) {
        int ans = 0;
        boolean[] cover = new boolean[words.length];
        for (int i =0;i<words.length;i++){
            for (int j = i+1;j<words.length;j++){
                if (words[i].length()>=words[j].length()){
                    if (words[i].substring(words[i].length()-words[j].length()).equals(words[j])){
                        cover[j] = true;
                    }

                } else {
                    if (words[j].substring(words[j].length()-words[i].length()).equals(words[i])){
                        cover[i] = true;
                    }
                }
            }
        }
        for (int i =0;i<cover.length;i++){
            if (!cover[i]){
                ans += words[i].length()+1;
            }
        }
        return ans;
    }
}
