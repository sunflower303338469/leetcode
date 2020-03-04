/**
 * Created by xuanmao on 2020/1/1.
 */
public class leetcode1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total = 0;
        for (int i =0;i<distance.length;i++){
            total = total+distance[i];
        }
        if (start>destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        int count = 0;
        for (int i=start;i<destination;i++){
            count = count+distance[i];
        }
        return Math.min(count, total-count);
    }
}
