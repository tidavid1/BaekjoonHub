class Solution {
    public boolean isPrime(long n){
        if (n < 2){
            return false;
        }
        for(long i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>k){
            sb.insert(0, n%k);
            n/=k;
        }
        sb.insert(0,n);
        String numbers = sb.toString().replaceAll("0", " ");
        for(String number:numbers.split(" ")){
            if(number.equals(""))
                continue;
            if(isPrime(Long.parseLong(number))){
                answer += 1;
            }
        }
        return answer;
    }
}