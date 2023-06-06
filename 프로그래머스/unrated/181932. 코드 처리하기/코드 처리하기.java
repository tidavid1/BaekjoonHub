class Solution {
    public String solution(String code) {
        String answer = "";
        boolean flag = true;
        char[] temp = code.toCharArray();
        for(int i=0; i< temp.length;i++){
            if(flag){
                if(temp[i] == '1'){
                    flag = false;
                }else{
                    if(i%2 == 0){
                        answer += temp[i];
                    }
                }
            }else{
                if(temp[i] == '1'){
                    flag = true;
                }else{
                    if(i%2 == 1){
                        answer += temp[i];
                    }
                }
            }
        }
        if (answer == ""){
            answer = "EMPTY";
        }
        return answer;
    }
}