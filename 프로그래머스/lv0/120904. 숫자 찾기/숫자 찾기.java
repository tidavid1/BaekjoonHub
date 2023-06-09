class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        char[] temp = Integer.toString(num).toCharArray();
        for(int i=0;i<temp.length;i++){
            if(temp[i] == (char)(k+'0')) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}