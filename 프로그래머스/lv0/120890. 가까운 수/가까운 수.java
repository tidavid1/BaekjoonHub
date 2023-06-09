class Solution {
    public int solution(int[] array, int n) {
        int answer = 101;
        int diff = 101;
        for(int i:array){
            if(Math.abs(i-n) < diff){
                answer = i;
                diff = Math.abs(i-n);
            }else if (Math.abs(i-n) == diff && answer > i){
                answer = i;
            }
        }
        return answer;
    }
}