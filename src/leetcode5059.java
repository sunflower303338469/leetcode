public class leetcode5059 {
    public int calculateTime(String keyboard, String word) {
       int[] ch = new int[26];
       for (int i =0;i<keyboard.length();i++){
           ch[keyboard.charAt(i)-'a'] = i;
       }
       int ans = 0;
       int index = 0;
       for (int j=0;j<word.length();j++){
           int p  = Math.abs(index - ch[word.charAt(j)-'a']);
           ans = ans +p;
           index = ch[word.charAt(j)-'a'];
       }
       return ans;
    }
}
