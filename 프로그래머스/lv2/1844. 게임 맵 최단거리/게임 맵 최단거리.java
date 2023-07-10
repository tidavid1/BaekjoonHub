import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length-1;
        int m = maps[n].length-1;
        BFS(n, m, maps);
        return maps[n][m] == 1 ? -1 : maps[n][m];
    }
    
    void BFS(int n, int m, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int[][] locations = {{x, y ==0 ? y : y-1},{x, y == m ? y: y+1}, {x==0?x:x-1, y}, {x == n ? x : x+1, y}};
            for(int[] location: locations){
                if((location[0] == x && location[1] == y) || (location[0] == 0 && location[1] == 0)){
                    continue;
                }
                if(maps[location[0]][location[1]] == 1){
                    maps[location[0]][location[1]]  = maps[x][y]+1;
                    queue.add(new int[]{location[0], location[1]});
                }
            }
        }
    }
}