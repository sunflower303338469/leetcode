/**
 * Created by xuanmao on 2019/5/13.
 */
public class leetcode838 {
    public String pushDominoes(String dominoes) {
        int [] left = new int [dominoes.length()];
        int [] right = new int [dominoes.length()];

        for (int i=1;i<dominoes.length();i++){
            if (dominoes.charAt(i) == '.'){
                if (dominoes.charAt(i-1) == 'R'){
                    right[i] = 1;
                } else if (dominoes.charAt(i-1) == '.') {
                    if (right[i-1]>0){
                        right[i] = right[i-1] + 1;
                    }
                }
            }
        }

        for (int i=dominoes.length()-2;i>=0;i--){
            if (dominoes.charAt(i) == '.'){
                if (dominoes.charAt(i+1) == 'L'){
                    left[i] = 1;
                } else if (dominoes.charAt(i+1) == '.') {
                    if (left[i+1]>0){
                        left[i] = left[i+1] + 1;
                    }
                }
            }
        }
        char[] ans = new char[dominoes.length()];
        for (int i=0;i<dominoes.length();i++){
            if (dominoes.charAt(i) == '.'){
                if (left[i] == right[i]){
                    ans[i] = '.';
                } else if ((left[i]>0) && (right[i]==0)){
                    ans[i]='L';
                } else if ((right[i]>0) && (left[i]==0)){
                    ans[i]='R';
                } else if(right[i]>left[i]){
                    ans[i]='L';
                } else {
                    ans[i]='R';
                }
            } else {
                ans[i]=dominoes.charAt(i);
            }
        }
        return String.valueOf(ans);
    }
}
