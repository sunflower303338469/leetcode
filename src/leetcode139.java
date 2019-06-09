import java.util.List;

/**
 * Created by xuanmao on 2019/5/23.
 */
public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for (int i=1;i<=s.length();i++){
            for (int j=0; j<wordDict.size();j++){
                if (i>=wordDict.get(j).length()){
                    if (wordDict.get(j).equals(s.substring(i-wordDict.get(j).length(),i))){
                        f[i] = f[i] || f[i-wordDict.get(j).length()];
                    }
                }
            }
        }
        return f[s.length()];
    }
}
