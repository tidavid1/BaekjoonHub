class Solution {
    public void make_table(int[][] arr, int x, int y, int n, int flag){
        arr[x][y] = n++;
        if(n > arr.length*arr.length) return;
        switch(flag){
            case 0 -> {
                if(y==arr[x].length-1 || arr[x][y+1] != 0){
                    flag = 1;
                    x++;
                } else y++; 
            }
            case 1-> {
                if(x == arr.length-1 || arr[x+1][y] != 0){
                    flag = 2;
                    y--;
                }else x++;
            }
            case 2-> {
                if(y == 0 || arr[x][y-1] != 0){
                    flag = 3;
                    x--;
                }else y--;
            }
            default ->{
                if(x ==0 || arr[x-1][y] != 0){
                    flag = 0;
                    y++;
                }else x--;
            }
        }
        make_table(arr, x, y, n ,flag);
    }
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        make_table(answer, 0, 0, 1, 0);
        return answer;
    }
}