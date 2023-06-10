class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean flag = false;
        for(String d:dic){
            int i=0;
            for(String s:spell){
                if(d.contains(s)) i++;
            }
            if(i == spell.length && d.length() == spell.length){
                flag = true;
                break;
            }
        }
        return flag?1:2;
    }
}