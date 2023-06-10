class Solution {
    public int solution(int angle) {
        int answer = 0;
        if(angle <90) answer = 1;
        else if(angle == 90) answer = 2;
        else answer = angle <180 ? 3: 4;
        return answer;
    }
}