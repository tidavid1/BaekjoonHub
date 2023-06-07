class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i:num_list){
            while(i != 1){
                i /=2;
                answer += 1;
            }
        }
        return answer;
    }
}