class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = '0';
        int c1 = 0;
        int c2 = 0;
        for(int i=0;i<s.length();i++){
            if(c == '0'){
                c = s.charAt(i);
                c1 = 1;
                c2 = 0;
                if(i == s.length()-1){
                    answer +=1;
                }
                continue;
            }
            if(c == s.charAt(i)){
                c1 += 1;
            }else{
                c2 += 1;
            }
            if(c1 == c2 ||i ==  s.length() -1){
                answer += 1;
                c = '0';
            }
        }
        return answer == 0 ? 1 : answer;
    }
}