class Solution {
    public void safe_area(int[][] board, int x, int y){
        for(int i=x-1<0?0:x-1; i<=(x+1>board.length-1?x:x+1);i++){
            for(int j = y-1<0?0:y-1; j<=(y+1>board[i].length-1?y:y+1);j++){
                if((i==x && j ==y)||(board[i][j] == 1)) continue;
                board[i][j] = 2;
            }            
        }
    }
    
    public int solution(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==1) safe_area(board, i, j);
            }
        }
        
        
        int answer = 0;
        for(int[] x:board){
            for(int y:x){
                if(y == 0) answer +=1;
            }
        }
        return answer;
    }
}