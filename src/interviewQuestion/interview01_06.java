package interviewQuestion;

/**
 * Created by xuanmao on 2020/9/10.
 */
public class interview01_06 {
    public String compressString(String S) {
        if (S==null){
            return null;
        }
        if (S.equals("")){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        Character c = S.charAt(0);
        int count = 1;
        for (int i =1;i<S.length();i++){
            if (c.equals(S.charAt(i))){
                count++;
            } else {
                sb.append(c);
                sb.append(count);
                c = S.charAt(i);
                count = 1;
            }
        }
        sb.append(c);
        sb.append(count);
        return sb.length()<S.length()?sb.toString():S;
    }
}
