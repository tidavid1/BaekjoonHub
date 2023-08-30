class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                answer += 1;
                DFS(i, computers, n);
            }
        }
        return answer;
    }
    
    void DFS(int idx, int[][] computers, int n){
        visited[idx] = true;
        for(int i=0;i<n;i++){
            if(visited[i] == false && computers[idx][i] == 1){
                DFS(i, computers, n);
            }
        }
    }
}