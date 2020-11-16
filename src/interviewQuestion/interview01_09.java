package interviewQuestion;

/**
 * Created by xuanmao on 2020/9/2.
 */
public class interview01_09 {
    public boolean isFlipedString(String s1, String s2) {
        s2 = s2+s2;
        return (s2.length()/2 == s1.length()) && s2.contains(s1);
    }
}
