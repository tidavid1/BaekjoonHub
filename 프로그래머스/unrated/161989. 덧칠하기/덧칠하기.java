class Solution {
    public int solution(int n, int m, int[] section) {
        int[] distances = new int[section.length-1];
        int answer = 0;
        int temp = 0;
        for(int i=0;i<section.length-1;i++){
            distances[i] = section[i+1]-section[i];
        }
        for(int i=0;i<distances.length;i++){
            if(temp+distances[i] >= m){
                temp = 0;
                answer += 1;
            }else{
                temp += distances[i];
            }
        }
        return answer+1;
    }
}