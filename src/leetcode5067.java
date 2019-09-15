public class leetcode5067 {
    public int countLetters(String S) {
        int ans = 1;
        int[] v = new int[S.length()];
        v[0]=1;
        for (int i=1;i<S.length();i++){
            if (S.charAt(i)== S.charAt(i-1)){
                v[i]=v[i-1]+1;
            } else {
                v[i]=1;
            }
            ans = ans+v[i];

        }
        return ans;
    }
}
