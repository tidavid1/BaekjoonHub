class Solution {
    public String solution(int n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int i=n%3;
            n/=3;
            if(i==0){
                i =4;
                n -= 1;
            }
            sb.insert(0, i);
        }
        return sb.toString();
    
    }
}