class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder answer = new StringBuilder();
        char[] temp = my_string.toCharArray();
        for(int i:index_list){
            answer.append(temp[i]);
        }
        return answer.toString();
    }
}