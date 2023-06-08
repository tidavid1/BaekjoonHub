class Solution {
    public String solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        sb.append(myString.substring(0, myString.lastIndexOf(pat)));
        sb.append(pat);
        return sb.toString();
    }
}