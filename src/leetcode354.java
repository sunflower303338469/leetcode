import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/6.
 */
public class leetcode354 {

    class Envelope{
        Integer w;
        Integer h;
        Envelope(Integer w, Integer h){
            this.w = w;
            this.h  =h;
        }

        public Integer getW(){
            return this.w;
        }

        public Integer getH(){
            return this.h;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length==0){
            return 0;
        }
        List<Envelope> envelopesList = new ArrayList<>();
        for (int i=0;i<envelopes.length;i++){
            envelopesList.add(new Envelope(envelopes[i][0], envelopes[i][1]));
        }
        envelopesList.sort(Comparator.comparing(Envelope::getW).thenComparing((Envelope e)->-e.getH()));
        List<Integer> ansList = new ArrayList<>();
        ansList.add(envelopesList.get(0).getH());
        for (int i =1;i<envelopesList.size();i++){
            Envelope envelope = envelopesList.get(i);
                if (envelope.getH()>ansList.get(ansList.size()-1)){
                    ansList.add(envelope.getH());
                } else {
                    int l = 0;
                    int r = ansList.size()-1;
                    while (l<r){
                        int mid = (l+r)/2;
                        if (ansList.get(mid)<envelope.getH()){
                            l = mid+1;
                        } else {
                            r = mid;
                        }
                    }
                    ansList.set(l, envelope.getH());
                }
        }

        return ansList.size();
    }
}
