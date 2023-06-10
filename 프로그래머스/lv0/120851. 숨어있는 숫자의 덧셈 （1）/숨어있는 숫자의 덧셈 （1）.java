class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[a-z,A-Z]", "");
        for(char c: my_string.toCharArray())
            answer += c-'0';
        return answer;
    }
}