class Solution {
    public int[] solution(long n) {
        String temp = String.valueOf(n);
        int idx = temp.length()-1;
        int[] answer = new int[idx+1];
        for(int i=0;i<answer.length;i++){
            answer[i] = temp.charAt(idx--)-'0';
        }
        return answer;
    }
}