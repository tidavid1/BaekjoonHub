class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String temp = s.toLowerCase();
        String[] words = temp.split(" ");
        for(int i=0;i<words.length;i++){
            if(words[i].length() == 0){
                sb.append(" ");
                continue;
            }
            sb.append(words[i].substring(0,1).toUpperCase()).append(words[i].substring(1));
            if(i != words.length-1 || s.substring(s.length()-1).equals(" ")){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}