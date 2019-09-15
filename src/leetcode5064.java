/**
 * Created by xuanmao on 2019/5/19.
 */
public class leetcode5064 {
    public String removeDuplicates(String S) {
        String[] tar = {"aa", "bb", "cc", "dd", "ee", "ff", "gg","hh", "ii", "jj", "kk","ll","mm", "nn","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"};
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i=0;i<tar.length;i++){
                if (S.contains(tar[i])){
                    S = S.replace(tar[i],"");
                    flag = true;
                }
            }
        }
        return S;
    }
}
