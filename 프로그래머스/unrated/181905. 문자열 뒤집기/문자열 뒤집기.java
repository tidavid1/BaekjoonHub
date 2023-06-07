class Solution {
    public String solution(String my_string, int s, int e) {
        char[] answer = my_string.toCharArray();
        String sub = my_string.substring(s,e+1);
        StringBuilder sb = new StringBuilder(sub);
        for(char c:sb.reverse().toString().toCharArray()){
            answer[s++] = c;
        }
        return new String(answer);
    }
}