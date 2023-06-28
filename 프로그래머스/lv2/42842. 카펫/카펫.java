class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        for(int i=3;i<brown+yellow;i++){
            if((brown+yellow)%i == 0 && (brown+yellow)/i >= 3){
                int col = Math.max(i, (brown+yellow)/i);
                int row = Math.min(i, (brown+yellow)/i);
                if((col-2)*(row-2) == yellow){
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
        }
        return answer;
    }
}