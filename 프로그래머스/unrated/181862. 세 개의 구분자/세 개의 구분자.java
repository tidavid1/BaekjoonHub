class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("a|b|c", " ").replaceAll("\\s+", " ").replaceAll("^\\s+", "");
        if (myStr.equals("")){
            return new String[]{"EMPTY"};
        }
        return myStr.split(" ");
    }
}