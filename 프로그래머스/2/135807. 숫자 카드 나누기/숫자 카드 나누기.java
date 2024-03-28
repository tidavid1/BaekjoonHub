class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int resultA = arrayA[0];
        int resultB = arrayB[0];
        for(int i=1;i<arrayA.length;i++){
            resultA = gcd(resultA, arrayA[i]);
            resultB = gcd(resultB, arrayB[i]);
        }
        
        answer = Math.max(answer, validateDivision(arrayB, resultA));
        answer = Math.max(answer, validateDivision(arrayA, resultB));
        
        return answer;
    }
    
    private int gcd(int a, int b){
        if(a%b==0){
            return b;
        }
        return gcd(b, a%b);
    }
    
    private int validateDivision(int[] arr, int n){
        for(int i:arr){
            if(i%n == 0){
                return 0;
            }
        }
        return n;
    }
}