class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(i%2==1?"수":"박");
        }
        return sb.toString();
    }
}