import java.util.*;
class Solution {
    public List<String> solution(String[] record) {
        Map<String, String> table = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(String s: record){
            String[] temp = s.split(" ");
            if(!temp[0].equals("Leave")){
                table.put(temp[1], temp[2]);
            }
        }
        for(String s:record){
            String[] temp = s.split(" ");
            StringBuilder sb = new StringBuilder();
            if(temp[0].equals("Enter")){
                sb.append(table.get(temp[1])).append("님이 들어왔습니다.");
            }else if(temp[0].equals("Leave")){
                sb.append(table.get(temp[1])).append("님이 나갔습니다.");
            }else{
                continue;
            }
            answer.add(sb.toString());
        }
        return answer;
    }
}