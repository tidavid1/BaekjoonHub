class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(;i<=j;i++){
            if(String.valueOf(i).contains(String.valueOf(k)))
                answer+=String.valueOf(i).length()-String.valueOf(i).replace(String.valueOf(k), "").length();
        }
        return answer;
    }
}