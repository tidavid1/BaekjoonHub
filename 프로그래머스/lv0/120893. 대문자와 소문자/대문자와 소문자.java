class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(char c:my_string.toCharArray()){
            sb.append(Character.isUpperCase(c)?Character.toLowerCase(c):Character.toUpperCase(c));
        }
        return sb.toString();
    }
}