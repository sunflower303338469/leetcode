/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode5118 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] temp = new int[n+1];
        int[] ans = new int[n];
        for (int i=0;i<bookings.length;i++){
            temp[bookings[i][0]-1] +=  bookings[i][2];
            temp[bookings[i][1]] -=  bookings[i][2];
        }
        int now = 0;
        for (int i=0;i<n;i++){

            now = now + temp[i];
            System.out.println(temp[i]+ " "+ now);
            ans[i] = now;
        }
        return ans;
    }

}
