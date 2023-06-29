class Solution {
    public long solution(int n) {
        long[] table = new long[n+2];
        for(int i=0;i<=n;i++){
            if(i<=2){
                table[i] = (long)i;
                continue;
            }
            table[i] = (table[i-1] + table[i-2])%1234567;
        }
        return table[n];
    }
}