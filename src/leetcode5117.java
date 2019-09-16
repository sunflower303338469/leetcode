/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode5117 {
    public String defangIPaddr(String address) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<address.length();i++){
            if (address.charAt(i) == '.'){
                stringBuffer.append("[.]");
            } else {
                stringBuffer.append(address.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
