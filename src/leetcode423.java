import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/7.
 */
public class leetcode423 {

    class English{
        String s;
        Character c;
        Integer num;
        English(String s, Character c,Integer num){
            this.s = s;
            this.c = c;
            this.num = num;
        }
    }

    public String originalDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        int[] nums = new int[10];
        for (int  i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        List<English> englishList = new ArrayList<>();
        englishList.add(new English("two", 'w',2));
        englishList.add(new English("eight", 'g',8));
        englishList.add(new English("three", 't',3));
        englishList.add(new English("four", 'u',4));
        englishList.add(new English("five", 'f',5));
        englishList.add(new English("six", 'x',6));
        englishList.add(new English("seven", 'v',7));
        englishList.add(new English("zero", 'z',0));
        englishList.add(new English("one", 'o',1));
        englishList.add(new English("nine", 'i',9));

        for (English e:englishList){
            int c = count[e.c-'a'];
            for (int i=0;i<e.s.length();i++){
                count[e.s.charAt(i)-'a'] -= c;
            }
            nums[e.num]+=c;
        }

        for (int i =0;i<nums.length;i++){
            for (int j=0;j<nums[i];j++){
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
