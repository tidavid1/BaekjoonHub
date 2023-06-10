class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        for(char c : Integer.toString(age).toCharArray()){
            sb.append((char)('a'+(char)Character.getNumericValue(c)));
        }
        return sb.toString();
    }
}