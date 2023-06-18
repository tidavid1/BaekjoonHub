class Solution {
    public boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public int solution(int n) {
        int answer = 0;
        for(int i=2;i<=n;i++){
            answer += isPrime(i) ? 1 : 0;
        }
        return answer;
    }
}