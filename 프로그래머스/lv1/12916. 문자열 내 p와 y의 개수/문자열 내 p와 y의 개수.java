class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int p = 0;
        int y = 0;
        for(char c:s.toCharArray()){
            if(c == 'p') p+=1;
            if(c == 'y') y+=1;
        }
        return p==y?true:false;
    }
}