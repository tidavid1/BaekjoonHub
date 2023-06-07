class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        c--;
        for(;c<my_string.length();c+=m){
            sb.append(my_string.substring(c,c+1));
        }
        return sb.toString();
    }
}