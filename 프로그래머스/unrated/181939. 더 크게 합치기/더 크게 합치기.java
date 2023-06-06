class Solution {
    public int solution(int a, int b) {
        String str_a = Integer.toString(a);
        String str_b = Integer.toString(b);
        a = Integer.parseInt(str_a+str_b);
        b = Integer.parseInt(str_b+str_a);
        int answer = a>b ? a : b; 
        return answer;
    }
}