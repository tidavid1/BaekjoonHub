class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s:babbling){
            s = s.replaceAll("ayaaya", "1").replaceAll("yeye", "1").replaceAll("woowoo", "1").replaceAll("mama", "1");
            s = s.replaceAll("aya", "2").replaceAll("ye", "2").replaceAll("woo", "2").replaceAll("ma", "2");
            if(s.matches("2+")){
                answer += 1;
            }
        }
        return answer;
    }
}