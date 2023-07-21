import java.util.*;
class Solution {
    boolean[] visited;
    Set<Integer> set;
    public int solution(String numbers){
        String[] numArr = numbers.split("");
        visited = new boolean[numArr.length];
        set = new HashSet<>();
        for(int i=0;i<numArr.length;i++){
            logic(numArr, i, "");
        }
        int answer = 0;
        for (int i:set) {
            answer += isPrime(i) ? 1 : 0;
        }
        return answer;
    }

    void logic(String[]numArr, int idx, String prev){
        if(visited[idx]){
            return;
        }
        set.add(Integer.parseInt(prev+numArr[idx]));
        visited[idx] = true;
        for(int i=0;i<numArr.length;i++){
            logic(numArr, i, prev+numArr[idx]);
        }
        visited[idx] = false;
    }

    boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
