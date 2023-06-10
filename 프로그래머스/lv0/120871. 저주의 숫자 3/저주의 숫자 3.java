class Solution {
    public int solution(int n) {
        for(int i=1;i<=n;i++){
            if(i%3==0 || Integer.toString(i).contains("3"))n++;
        }
        return n;
    }
}