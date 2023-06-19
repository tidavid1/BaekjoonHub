import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int N, int[] stages) {
        Arrays.sort(stages);
        Map<Double, ArrayList> table = new TreeMap<>(Comparator.reverseOrder());
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> idxes;
        for(int i=1;i<=N;i++){
            double num = 0;
            double fail = 0;
            for(int j:stages){
                if (j<i) continue;
                num += 1;
                if(i == j) fail += 1;
            }
            double idx = num==0 ? -1 : fail/num;
            if(table.get(idx) == null){
                idxes = new ArrayList<>();
            }else{
                idxes = table.get(idx);
            }
            idxes.add(i);
            idxes.sort(Comparator.naturalOrder());
            table.put(idx, idxes);
        }
        for(double d:table.keySet()){
            answer.addAll(table.get(d));
        }
        return answer;
    }
}