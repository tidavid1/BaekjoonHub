class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(s.length() > 1){
            answer[1] += s.length() - s.replace("0", "").length();
            answer[0] += 1;
            s = Integer.toBinaryString(s.replace("0", "").length());
        }
        return answer;
    }
}