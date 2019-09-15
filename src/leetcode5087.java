/**
 * Created by xuanmao on 2019/6/9.
 */
public class leetcode5087 {
    int [] p = new int[26];
    int ans =0;
    public int numTilePossibilities(String tiles) {
        for (int i=0;i<tiles.length();i++){
            p[(int)tiles.charAt(i)-(int)'A']++;
        }
        try1(0);
        return ans;
    }
    private void try1(int n){
        for (int i=0;i<26;i++){
            if (p[i]>0){
                ans ++;
                p[i] = p[i]-1;
                try1(n+1);
                p[i]= p[i]+1;
            }
        }
    }
}
