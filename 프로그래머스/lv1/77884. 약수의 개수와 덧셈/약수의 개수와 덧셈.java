import java.util.ArrayList;
class Solution {
    public int calc_divisor(int n){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0) answer.add(i);
        }
        return answer.size();
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for(;left<=right;left++){
            answer += calc_divisor(left)%2==0?left:(-1)*left;
        }
        return answer;
    }
}