class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = included[0]?a:0;
        for(int i=1;i<included.length;i++){
            if(included[i]){
                answer += a + (d*i);
            }
        }
        return answer;
    }
}