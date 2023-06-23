class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {wallpaper.length,wallpaper[0].length(),0,0};
        for(int i=0;i<wallpaper.length;i++){
            if(wallpaper[i].contains("#")){
                answer[0] = Math.min(answer[0], i);
                answer[2] = Math.max(answer[2], i+1);
            }
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j) == '#'){
                    answer[1] = Math.min(answer[1], j);
                    answer[3] = Math.max(answer[3], j+1);
                }
            }
        }
        return answer;
    }
}