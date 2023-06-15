class Solution {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        for(int[] size:sizes){
            x = x< Math.max(size[0], size[1]) ? Math.max(size[0], size[1]) : x;
            y = y< Math.min(size[0], size[1]) ? Math.min(size[0], size[1]) : y;
        }
        return x*y;
    }
}