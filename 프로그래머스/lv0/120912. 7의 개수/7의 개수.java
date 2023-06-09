class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i:array){
            String s = Integer.toString(i);
            s = s.replaceAll("[0-6]|[8-9]", "");
            answer += s.length();
        }
        return answer;
    }
}