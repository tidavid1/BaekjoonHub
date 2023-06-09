import java.util.*;
class Solution {
    public ArrayList<Double> solution(int[][] score) {
        ArrayList<Double> answer = new ArrayList<>();
        HashMap<Double, Integer> table = new HashMap<>();
        for (int[] ints : score) {
            answer.add((double)(ints[0] + ints[1]) / 2);
        }
        for(double i:answer){
            table.put(i, table.get(i)==null?1:table.get(i)+1);
        }
        double rating = 0;
        for(double i: table.keySet().stream().sorted(Comparator.reverseOrder()).mapToDouble(x->x).toArray()){
            for(int j=0;j<table.get(i);j++){
                answer.set(answer.indexOf(i), rating);
            }
            rating += table.get(i);
        }
        for(int i=0;i<answer.size();i++){
            answer.set(i, answer.get(i)+1);
        }
        return answer;
    }
}