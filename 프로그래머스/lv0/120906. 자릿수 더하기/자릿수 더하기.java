class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=0;i<Integer.toString(n).length();i++){
            answer += Integer.toString(n).charAt(i) -'0';
        }
        return answer;
    }
}