class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        for(int i=0;i<board.length;i++) board[i]/=2;
        int[] answer = new int[2];
        for(String s:keyinput){
            switch(s){
                case "left"->{
                    if(answer[0] == board[0]*-1) continue;
                    answer[0]-=1;
                }
                case "right"->{
                    if(answer[0] == board[0]) continue;
                    answer[0]+=1;
                }
                case "up" -> {
                    if(answer[1] == board[1]) continue;
                    answer[1]+=1;
                }
                default-> {
                    if(answer[1] == board[1]*-1) continue;
                    answer[1]-=1;
                }
            }
        }
        return answer;
    }
}