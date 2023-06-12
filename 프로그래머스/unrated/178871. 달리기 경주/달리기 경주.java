import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> table = new HashMap<>();
        for(int i=0;i<players.length;i++){
            table.put(players[i], i);
        }
        for(String call:callings){
            players[table.get(call)] = players[table.get(call)-1];
            players[table.get(call)-1] = call;
            table.put(players[table.get(call)], table.get(players[table.get(call)])+1);
            table.put(call, table.get(call)-1);
        }

        return players;
    }
}