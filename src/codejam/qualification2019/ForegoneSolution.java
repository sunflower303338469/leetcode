package codejam.qualification2019;

import java.util.Scanner;

/**
 * Created by xuanmao on 2020/4/3.
 */
public class ForegoneSolution {
    private static String PATTEN = "Case #%d: %s %s";

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i =1;i<=t;i++){
            String N = sc.nextLine();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int j=0;j<N.length();j++){
                if (N.charAt(j)=='4'){
                    a.append('2');
                    b.append('2');
                } else {
                    a.append(N.charAt(j));
                    if (b.length()>0){
                        b.append('0');
                    }
                }


            }
            if (b.length()==0){
                b.append('0');
            }
            System.out.println(String.format(PATTEN, i, a.toString(), b.toString()));
        }
    }
}
