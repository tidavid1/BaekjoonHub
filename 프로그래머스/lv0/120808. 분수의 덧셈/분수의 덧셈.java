class Solution {
    
    int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        if (denom2 % denom1 == 0){
            numer1 *= denom2/denom1;
            denom1 = denom2;
        } else if (denom2 % denom1 == 0){
            numer2 *= denom1/denom2;
            denom2 = denom1;   
        } else {
            numer1 *= denom2;
            numer2 *= denom1;
            denom1 *= denom2;
        }
        int temp = gcd(numer1+numer2, denom1);
        return new int[]{(numer1+numer2)/temp, denom1/temp};
    }
}