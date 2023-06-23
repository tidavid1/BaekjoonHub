import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> table = new HashMap<>();
        for(String term:terms){
            table.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }
        for(int i=0;i<privacies.length;i++){
            LocalDate privacyDate = LocalDate.parse(privacies[i].split(" ")[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            if(privacyDate.plusMonths(table.get(privacies[i].split(" ")[1])).minusDays(1).isBefore(todayDate)){
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}