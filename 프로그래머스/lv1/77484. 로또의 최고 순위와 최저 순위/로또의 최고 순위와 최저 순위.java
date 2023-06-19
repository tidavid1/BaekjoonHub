class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correct = 0;
        int zero = 0;
        for(int lotto:lottos){
            if(lotto == 0){
                zero += 1;
            }else{
                for(int nums: win_nums){
                    if(lotto == nums){
                        correct += 1;
                        break;
                    }
                }
            }
        }
        return new int[]{7-Math.max(correct+zero, 1), 7-Math.max(correct, 1)};
    }
}