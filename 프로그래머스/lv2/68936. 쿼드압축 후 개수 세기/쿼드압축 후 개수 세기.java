class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        quadzip(arr, 0, 0, arr.length, answer);
        return answer;
    }
    
    boolean zip(int[][] arr, int x, int y, int size){
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j] != arr[x][y])
                    return false;
            }
        }
        return true;
    }
    
    void quadzip(int[][] arr, int x, int y, int size, int[] answer){
        if(zip(arr, x, y, size)){
            answer[arr[x][y]] += 1;
            return;
        }
        quadzip(arr,x,y, size/2, answer);
        quadzip(arr,x,y + size/2, size/2, answer);
        quadzip(arr,x+size/2,y, size/2, answer);
        quadzip(arr,x+size/2,y + size/2, size/2, answer);
    }
}