class Solution {
    public int solution(String binomial) {
        String[] temp = binomial.split(" ");
        int answer = switch(temp[1]){
                case "+" -> Integer.valueOf(temp[0]) + Integer.valueOf(temp[2]);
                case "-" -> Integer.valueOf(temp[0]) - Integer.valueOf(temp[2]);
                default -> Integer.valueOf(temp[0]) * Integer.valueOf(temp[2]);
        };
        return answer;
    }
}