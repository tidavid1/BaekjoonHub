class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        for(int i =0; i<dots.length;i++) {
            float temp =gradient(dots[i],dots[(i+1)%4]);
            float temp2 =gradient(dots[(i+2)%4],dots[(i+3)%4]);
            if(temp==temp2) answer = 1;
        }
        return answer;
    }
    
    public static float gradient(int[]a1,int[]a2) {
        float temp1,temp2;
        temp1= a1[0]-a2[0];
        temp2= a1[1]-a2[1];
        return temp1/temp2;
    }
}