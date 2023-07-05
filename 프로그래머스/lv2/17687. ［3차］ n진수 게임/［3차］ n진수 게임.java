class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=t*m;i++){
            sb.append(Integer.toString(i, n));
        }
        for(int i=p;i<=t*m;i+=m){
            answer.append(sb.charAt(i-1));
        }
        return answer.toString().toUpperCase();
    }
}