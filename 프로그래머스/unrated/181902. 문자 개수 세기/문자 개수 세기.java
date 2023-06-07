class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char c:my_string.toCharArray()){
            if(c <= 'Z'){
                answer[c-'A'] += 1;
            }else{
                answer[c-'A'-6] +=1;
            }
        }
        return answer;
    }
}