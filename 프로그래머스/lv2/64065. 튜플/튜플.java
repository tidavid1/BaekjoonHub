import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        s = s.replaceAll("^\\{\\{", "").replaceAll("\\}\\}", "").replaceAll("\\},\\{", "|");
        String[] temp = s.split("\\|");
        Arrays.sort(temp, Comparator.comparingInt(String::length));
        for (String value : temp) {
            for (int j = 0; j < value.split(",").length; j++) {
                if (answer.contains(Integer.parseInt(value.split(",")[j]))) {
                    continue;
                }
                answer.add(Integer.parseInt(value.split(",")[j]));
            }
        }
        return answer;
    }
}