/**
 * Created by xuanmao on 2019/1/25.
 */
public class leetcode273 {
    public String numberToWords(int num) {
        String result = "";
        int d = 0;
        while (num >0){
            int x = num % 1000;
            if ((danwei(d) != null) && (x != 0)){
                result = danwei(d) + result;
            }
            int gewei = x % 10;
            x = x /10;
            int shiwei = x % 10;
            x = x /10;
            int baiwei = x % 10;
            x = x /10;

            if (shiwei<=1){
                int p = shiwei * 10 + gewei;
                if (geweishu(p) != null){
                    result = geweishu(p) + result;
                }
            } else {
                if (geweishu(gewei) != null){
                    result = geweishu(gewei) + result;
                }
                result = shiweishu(shiwei) + result;
            }
            if (baiwei>0){
                result = geweishu(baiwei) + " Hundred" + result;
            }

            d += 1;
            num = num / 1000;
        }
        if (result.equals("")){
            return "Zero";
        }
        return result.substring(1);
    }

    private String geweishu(int x){
        switch (x){
            case 1:
                return " One";
            case 2:
                return " Two";
            case 3:
                return " Three";
            case 4:
                return " Four";
            case 5:
                return " Five";
            case 6:
                return " Six";
            case 7:
                return " Seven";
            case 8:
                return " Eight";
            case 9:
                return " Nine";
            case 10:
                return " Ten";
            case 11:
                return " Eleven";
            case 12:
                return " Twelve";
            case 13:
                return " Thirteen";
            case 14:
                return " Fourteen";
            case 15:
                return " Fifteen";
            case 16:
                return " Sixteen";
            case 17:
                return " Seventeen";
            case 18:
                return " Eighteen";
            case 19:
                return " Nineteen";
            default:
                return null;
        }
    }

    private String shiweishu(int x){
        switch (x){
            case 2:
                return " Twenty";
            case 3:
                return " Thirty";
            case 4:
                return " Forty";
            case 5:
                return " Fifty";
            case 6:
                return " Sixty";
            case 7:
                return " Seventy";
            case 8:
                return " Eighty";
            case 9:
                return " Ninety";
        }
        return null;
    }

    private String danwei(int x){
        switch (x){
            case 1:
                return " Thousand";
            case 2:
                return " Million";
            case 3:
                return " Billion";
        }
        return null;
    }
}
