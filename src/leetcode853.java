/**
 * Created by xuanmao on 2020/2/12.
 */
public class leetcode853 {
    int[] father;
    public int carFleet(int target, int[] position, int[] speed) {
        father = new int[position.length];
        for (int i=0;i<position.length;i++){
            father[i] = i;
        }
        for (int i = 0;i<position.length;i++){
            for (int j =i+1;j<position.length;j++){
                if (father[i]!=i){
                    continue;
                }
                if ((position[i]==position[j]) && (speed[i] == speed[j])){
                    father[i] = getFather(j);
                    continue;
                }
                double t = ((double) (position[j]-position[i]))/(speed[i]-speed[j]);
                double pos = speed[i]*t+position[i];
                if ((t>0) && (pos>0) && (pos<=target)){
                    System.out.println(i+" "+j);
                    if (speed[i]>speed[j]){
                        father[i] = getFather(j);
                    } else {
                        father[j] = getFather(i);
                    }
                }
            }
        }
        int count = 0;
        for (int i =0;i<father.length;i++){
            if (father[i] == i){
                count++;
            }
        }
        return count;
    }

    private int getFather(int index){
        while (father[index] != index){
            father[index] = father[father[index]];
            index = father[index];
        }
        return index;
    }
}
