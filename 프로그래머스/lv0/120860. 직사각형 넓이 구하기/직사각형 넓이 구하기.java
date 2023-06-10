class Solution {
    public int solution(int[][] dots) {
        int[] temp = null;
        for(int[] dot: dots){
            temp = temp==null?dot : temp;
            if(dot[0] != temp[0] && dot[1] != temp[1]){
                return Math.abs(dot[0] - temp[0])*Math.abs(dot[1] - temp[1]);
            }
        }
        return 0;
    }
}