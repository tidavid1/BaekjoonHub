class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mul = 1;
        for(int i: num_list){
            sum+=i;
            mul*=i;
        }
        int answer = mul < sum*sum ? 1 : 0;
        return answer;
    }
}