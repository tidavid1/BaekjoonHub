class Solution {
    public int solution(int hp) {
        final int[] ANTS = {5,3,1};
        int answer = 0;
        for(int ant:ANTS){
            answer += hp/ant;
            hp = hp%ant;
        }
        return answer;
    }
}