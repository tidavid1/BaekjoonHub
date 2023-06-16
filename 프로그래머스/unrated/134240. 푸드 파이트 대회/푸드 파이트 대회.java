class Solution {
    public String solution(int[] food) {
        StringBuilder builder = new StringBuilder();
        for(int i=1;i<food.length;i++){
            builder.append(Integer.toString(i).repeat(food[i]/2));
        }
        StringBuffer buffer = new StringBuffer(builder.toString());
        builder.append("0").append(buffer.reverse().toString());
        return builder.toString();
    }
}