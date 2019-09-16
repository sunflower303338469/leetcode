import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class leetcode1135 {
    class Edge{
        Integer x;
        Integer y;
        Integer cost;
    }
    int[] f= new int[10001];
    public int minimumCost(int N, int[][] conections) {
        List<Edge> edgeList = new ArrayList<>();
        for (int i=0;i<conections.length;i++){
            Edge e =  new Edge();
            e.x= conections[i][0];
            e.y=conections[i][1];
            e.cost=conections[i][2];
            edgeList.add(e);
        }
        edgeList.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge edge, Edge t1) {
                return edge.cost.compareTo(t1.cost);
            }
        });
        for (int i =1;i<=N;i++){
            f[i] = i;
        }
        int ans = 0;
        int count = 0;
        for (Edge e:edgeList){
            if (getFather(e.x) != getFather(e.y)){
                System.out.println(e.x+ " "+ e.y);
                f[getFather(e.x)] = getFather(e.y);
                ans = ans + e.cost;
                count ++;
            }
        }
        if (count == N-1){
            return ans;
        } else {
            return -1;
        }

    }
    private int getFather(Integer x){
        while (f[x] != x){
            f[x] = f[f[x]];
            x =f[x];
        }
        return f[x];
    }


    public static void main(String args[]) {
        leetcode1135 s = new leetcode1135();
        int[][] conections = {
                {1,2,1},
                {1,3,2},
                {3,4,4},
                {1,4,3}
        };
        System.out.println(s.minimumCost(4, conections));
    }
}
