class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int x = 0;
        int y = 0;
        for(int i:num_list){
            answer[x][y++] = i;
            if(y == n){
                x++;
                y = 0;
            }
        }
        return answer;
    }
}