class Solution {
    public int countvalues(int n){
        int answer = 0;
        for(int i=1;i*i<=n;i++){
            if(i*i == n) answer +=1;
            else if(n%i==0) answer +=2;
        }
        return answer;
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            answer += countvalues(i) <= limit ? countvalues(i) : power;
        }
        return answer;
    }
}