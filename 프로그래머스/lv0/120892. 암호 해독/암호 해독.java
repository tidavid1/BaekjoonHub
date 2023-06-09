class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        for(int i=code-1; i<cipher.length();i+=code){
            sb.append(cipher.substring(i,i+1));
        }
        return sb.toString();
    }
}