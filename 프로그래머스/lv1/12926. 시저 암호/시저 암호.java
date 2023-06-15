class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c == ' '){sb.append(c);}
            else if('a'<=c && c<='z'){
                if(c+n > 'z') sb.append((char)(c+n-26));
                else sb.append((char)(c+n));
            }else{
                if(c+n > 'Z') sb.append((char)(c+n-26));
                else sb.append((char)(c+n));
            }
        }
        return sb.toString();
    }
}