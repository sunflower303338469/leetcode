/**
 * Created by xuanmao on 2019/8/25.
 */
public class leetcode5168 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qu = new int[queries.length];
        int[] wo = new int[words.length];
        for (int i=0;i<queries.length;i++){
            qu[i] = getF(queries[i]);
        }
        for (int j=0;j<words.length;j++){
            wo[j] = getF(words[j]);
        }
        int [] ans = new int[queries.length];
        for (int i=0;i<queries.length;i++){
            for (int j=0;j<words.length;j++){
                if (qu[i]<wo[j]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    private int getF(String s){
        if (s.isEmpty()){
            return 0;
        }
        int value = 0;
        int max = 10000;
        for (int i =0;i<s.length();i++){
            if (s.charAt(i) - 'a'==max){
                value ++;
            }
            if (s.charAt(i) - 'a'<max){
                value = 1;
                max = s.charAt(i) - 'a';
            }
        }
        return value;
    }
}
