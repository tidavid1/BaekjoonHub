import java.util.*;

class Solution {
    private static final Map<Integer, List<Integer>> MAP = new HashMap<>();
    private static final Queue<Integer> QUEUE = new LinkedList<>();
    private static boolean[] visited;
    private static int result = 0;
    public int solution(int n, int[][] edges) {
        visited = new boolean[n+1];
        for(int[] edge: edges){
            var list = MAP.getOrDefault(edge[0], new ArrayList<Integer>());
            list.add(edge[1]);
            MAP.put(edge[0], list);
            list = MAP.getOrDefault(edge[1], new ArrayList<Integer>());
            list.add(edge[0]);
            MAP.put(edge[1], list);
        }
        QUEUE.add(1);
        visited[1] = true;
        while(!QUEUE.isEmpty()) {
            result = bfs();
        }
        return result;
    }
    
    private static int bfs() {
        int size = QUEUE.size();
        for(int i=0;i<size;i++) {
            var node = QUEUE.poll();
            for(int j:MAP.get(node)){
                if(!visited[j]){
                    visited[j] = true;
                    QUEUE.add(j);
                }
            }
        }
        return size;
    }
}