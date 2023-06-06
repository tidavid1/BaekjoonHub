class Solution {
    public int solution(int a, int b) {
        int temp = Integer.valueOf(""+a+b);
        int answer = temp > 2*a*b ? temp : 2*a*b;
        return answer;
    }
}