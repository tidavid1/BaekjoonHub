import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int n, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1;i<=n/k;i++){
            answer.add(i*k);
        }
        return answer;
    }
}