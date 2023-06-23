import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> reportedIDs = new HashMap<>();
        Map<String, Integer> receiveEmailCount = new HashMap<>();
        int[] answer = new int[id_list.length];
        report = Arrays.stream(report).distinct().toArray(String[]::new);

        for (String s : report) {
            String[] reported = s.split(" ");
            List<String> list = reportedIDs.getOrDefault(reported[1], new ArrayList<>());
            list.add(reported[0]);
            reportedIDs.put(reported[1], list);
        }
        for(String name:reportedIDs.keySet()){
            if(reportedIDs.get(name).size()>=k){
                for(String s:reportedIDs.get(name)){
                    receiveEmailCount.put(s, receiveEmailCount.getOrDefault(s, 0)+1);
                }
            }
        }
        for(int i=0;i<id_list.length;i++){
            answer[i] = receiveEmailCount.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}