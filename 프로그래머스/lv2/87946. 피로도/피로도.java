class Solution {
    boolean[] visited;
    int count = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(0, k, dungeons);
        return count;
    }
    
    void DFS(int depth, int k, int[][] dungeons){
        for (int i = 0; i < dungeons.length; i++){  
            if (visited[i] || dungeons[i][0] > k) {  
                continue;  
            }  
            visited[i] = true;  
            DFS(depth + 1, k - dungeons[i][1], dungeons);  
            visited[i] = false;  
        }  
        count = Math.max(count, depth); 
    }
}