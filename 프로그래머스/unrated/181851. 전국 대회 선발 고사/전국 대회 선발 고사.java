import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int temp = 10000;
        int[] temp_rank = rank.clone();
        HashMap<Integer, Boolean> table = new HashMap<>();
        for(int i=0;i<rank.length;i++){
            table.put(rank[i], attendance[i]);
        }
        Arrays.sort(rank);
        for(int i:rank){
            if(table.get(i)){
                int idx = 0;
                for(;idx<temp_rank.length;idx++){
                    if(temp_rank[idx] == i) break;
                }
                answer += (temp*idx);
                if(temp == 1){
                    break;
                }
                temp /=100;
            }
        }
        return answer;
    }
}