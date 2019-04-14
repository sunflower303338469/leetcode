import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class tes {
    public static void main(String[] args) {
        List<String> slist = new ArrayList<>();
        String ss=  "213123123";
        slist.add(ss);
        ss = "123123";
        slist.add(ss);
    }

    public String licenseKeyFormatting(String S, int K) {
        String re = new String();
        S = S.replace("-","");
        S = S.toUpperCase();
        int count = S.length() % K;
        if (count == 0){
            count = K;
        }
        for (int i=0; i<S.length(); i++){
            if (count == 0){
                count = K;
                re = re + "-";
            }
            re = re + S.charAt(i);
            count = count - 1;
        }
        return re;
    }
}