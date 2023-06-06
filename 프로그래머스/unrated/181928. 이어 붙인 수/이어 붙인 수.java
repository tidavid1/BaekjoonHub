class Solution {
    public int solution(int[] num_list) {
        String odd = "";
        String even = "";
        for(int i:num_list){
            if(i%2 == 0){
                even += i;
            } else{
                odd += i;
            }
        }
        return Integer.valueOf(even) + Integer.valueOf(odd);
    }
}