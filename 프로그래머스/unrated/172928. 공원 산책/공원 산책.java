class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[][] map = new int[park.length][];
        int[] locate = {0,0};
        for(int i=0;i<park.length;i++){
            map[i] = new int[park[i].length()];
        }
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                switch (park[i].charAt(j)) {
                    case 'X' -> map[i][j] = 1;
                    case 'S' -> locate = new int[]{i, j};
                }
            }
        }
        for(String route: routes){
            String direction = route.split(" ")[0];
            int step = Integer.parseInt(route.split(" ")[1]);
            boolean flag = true;
            switch(direction){
                case "E":
                    for(int i=1;i<=step;i++){
                        if(locate[1]+i >= map[locate[0]].length){
                            flag = false;
                            break;
                        }else if(map[locate[0]][locate[1]+i] == 1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        locate[1] += step;
                    }
                    break;
                case "W":
                    for(int i=1;i<=step;i++){
                        if(locate[1]-i < 0){
                            flag = false;
                            break;
                        }else if(map[locate[0]][locate[1]-i] == 1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        locate[1] -= step;
                    }
                    break;
                case "S":
                    for(int i=1;i<=step;i++){
                        if(locate[0]+i >= map.length){
                            flag = false;
                            break;
                        }else if(map[locate[0]+i][locate[1]] == 1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        locate[0] += step;
                    }
                    break;
                default:
                    for(int i=1;i<=step;i++){
                        if(locate[0]-i <0){
                            flag = false;
                            break;
                        }else if(map[locate[0]-i][locate[1]] == 1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        locate[0] -= step;
                    }
            }
        }
        return locate;
    }
}