public class leetcode5022 {
    int[] a = new int[26];

    public int numKLenSubstrNoRepeats(String S, int K) {
        int sum = 0;
        if (S.length()<K){
            return 0;
        }
        for (int i=0;i<K;i++){
            a[S.charAt(i) - 'a'] ++;
        }
        if (check()){
            sum = sum +1;
        }
        for (int i=K;i<S.length();i++){
            a[S.charAt(i-K) - 'a']--;
            a[S.charAt(i)-'a']++;
            if (check()){
                sum++;
            }
        }
        return sum;
    }

    private boolean check(){
        for (int i=0;i<a.length;i++){
            if (a[i]>1){
                return false;
            }
        }
        return true;
    }
}
