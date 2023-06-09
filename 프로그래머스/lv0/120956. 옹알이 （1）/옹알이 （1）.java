class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String s:babbling)
            if (s.matches("(aya||ye||woo||ma)+"))
                answer++;
        
        return answer;
    }
}