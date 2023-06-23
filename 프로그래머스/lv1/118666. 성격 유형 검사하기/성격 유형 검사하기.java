import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> table = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<survey.length;i++){
            if(choices[i] < 4){
                table.put(survey[i].substring(0,1), table.getOrDefault(survey[i].substring(0,1), 0)+4-choices[i]);
            }else if(choices[i] > 4){
                table.put(survey[i].substring(1), table.getOrDefault(survey[i].substring(1), 0)+choices[i]-4);
            }
        }
        sb.append(table.getOrDefault("T", 0) > table.getOrDefault("R", 0) ? "T" : "R");
        sb.append(table.getOrDefault("F", 0) > table.getOrDefault("C", 0) ? "F" : "C");
        sb.append(table.getOrDefault("M", 0) > table.getOrDefault("J", 0) ? "M" : "J");
        sb.append(table.getOrDefault("N", 0) > table.getOrDefault("A", 0) ? "N" : "A");
        return sb.toString();
    }
}