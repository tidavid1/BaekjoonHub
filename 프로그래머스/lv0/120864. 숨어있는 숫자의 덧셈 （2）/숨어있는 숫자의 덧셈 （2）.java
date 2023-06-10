class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(String s:my_string.toLowerCase().replaceAll("[a-z]", " ").replaceAll("^\\s+", "").replaceAll("\\s+", " ").split(" ")){
            if(s.equals("")) continue;
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}