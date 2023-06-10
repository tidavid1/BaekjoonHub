class Solution {
    public String solution(String polynomial) {
        int linear_term = 0;
        int num = 0;
        for(String s: polynomial.split(" ")){
            if(s.contains("x"))
                linear_term += s.equals("x")?1:Integer.valueOf(s.replace("x", ""));
            else if(s.contains("+"))
                continue;
            else
                num += Integer.valueOf(s);
        }
        StringBuilder sb = new StringBuilder();
        if(linear_term == 1){
            sb.append("x");
        }else if (linear_term !=0){
            sb.append(Integer.toString(linear_term)).append("x");
        }
        if(num != 0){
            if(linear_term ==0){
                sb.append(Integer.toString(num));
            }else{
                sb.append(" + ").append(Integer.toString(num));
            }

        }
        return sb.toString();
    }
}