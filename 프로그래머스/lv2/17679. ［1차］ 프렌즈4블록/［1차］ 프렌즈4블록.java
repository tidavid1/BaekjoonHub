class Solution {
    boolean[][] visited;
    public int solution(int m, int n, String[] board) {
        visited = new boolean[m][n];
        int answer = 0;
        String[][] table = new String[m][n];
        for(int i=0;i<board.length;i++){
            table[i] = board[i].split("");
        }
        while(true){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    checkSquare(i,j,m,n,table,0);
                }
            }
            int temp = 0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(visited[i][j]){
                        table[i][j] = "";
                        temp += 1;
                    }
                }
            }
            if(temp == 0) {
                break;
            }else{
                answer += temp;
            }
            visited = new boolean[m][n];
            moveBlock(m,n,table);
        }
        return answer;
    }
    
    private void moveBlock(int m, int n, String[][] table) {
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(table[j][i].equals("")){
                    for(int k=j;k>0;k--){
                        swap(i, k, k-1, table);
                    }
                }
            }
        }
    }

    private void swap(int i, int j, int k, String[][] table) {
        String temp = table[j][i];
        table[j][i] = table[k][i];
        table[k][i] = temp;
    }

    private void checkSquare(int x, int y, int m, int n, String[][] table ,int flag){
        if(table[x][y].equals("")){
            return;
        }
        switch (flag){
            case 0 ->{
                if(y+1 == n){
                    return;
                }
                if(table[x][y].equals(table[x][y+1])){
                    checkSquare(x, y+1, m, n, table, flag+1);
                }
            }
            case 1 ->{
                if(x+1 == m){
                    return;
                }
                if(table[x][y].equals(table[x+1][y])){
                    checkSquare(x+1, y, m, n, table, flag+1);
                }
            }
            case 2 ->{
                if(y == 0){
                    return;
                }
                if(table[x][y].equals(table[x][y-1])){
                    checkSquare(x,y-1,m,n,table,flag+1);
                }
            }
            case 3->{
                if(x == 0){
                    return;
                }
                if(table[x][y].equals(table[x-1][y])){
                    checkSquare(x-1, y, m, n, table, flag+1);
                }
            }
            default -> {
                int[][] locations = new int[][]{{x, y}, {x, y+1}, {x+1,y+1}, {x+1, y}};
                for(int[] location:locations){
                    visited[location[0]][location[1]] = true;
                }
            }
        }
    }
}