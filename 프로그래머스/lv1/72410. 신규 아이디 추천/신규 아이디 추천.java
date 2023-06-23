class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "").replaceAll("[.]+", ".");
        new_id = new_id.replaceAll("^[.]+", "").replaceAll("[.]+$", "");
        if(new_id.length() == 0){
            new_id = "a";
        }
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15).replaceAll("[.]+$", "");
        }
        if(new_id.length() <=2){
            new_id+= new_id.substring(new_id.length()-1 ,new_id.length()).repeat(3-new_id.length());
        }
        return new_id;
    }
}