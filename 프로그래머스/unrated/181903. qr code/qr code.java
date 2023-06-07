class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for(;r<code.length();r+=q){
            sb.append(code.substring(r, r+1));
        }
        return sb.toString();
    }
}