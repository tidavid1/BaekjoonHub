class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[201];
        for(int[] line:lines){
            for(int i=line[0]+100;i<line[1]+100;i++){
                arr[i] += 1;
            }
        }
        int answer = 0;
        for(int i:arr){
            if(i>=2) answer++;
        }
        return answer;
    }
}