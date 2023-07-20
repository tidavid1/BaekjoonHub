class Solution {
    int max = 0;
    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        dfs(0, visited, info, edges,0, 0);
        return max;
    }

    public void dfs(int idx, boolean[] visited, int[]info, int[][]edges, int sheep, int wolf) {
        visited[idx] = true;
        if (info[idx] == 0) {
            sheep++;
            max = Math.max(sheep, max);
        } else {
            wolf++;
        }
        if (sheep <= wolf) {
            return;
        }
        for (int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nextVisited = new boolean[visited.length];
                System.arraycopy(visited, 0, nextVisited, 0, visited.length);
                dfs(edge[1], nextVisited, info, edges,sheep, wolf);
            }
        }
    }
}