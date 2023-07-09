import java.util.*;
class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        Set<String> visit = new HashSet<>();

        for(String dir:dirs.split("")){
            StringBuilder before = new StringBuilder();
            before.append(x).append(y);
            switch (dir){
                case "U" ->{
                    if(y-1 < -5){
                        continue;
                    }
                    y -=1;
                }
                case "D" ->{
                    if(y+1 >5){
                        continue;
                    }
                    y +=1;
                }
                case "L" ->{
                    if(x-1 < -5){
                        continue;
                    }
                    x -=1;
                }
                default ->{
                    if(x+1 > 5){
                        continue;
                    }
                    x += 1;
                }
            }
            StringBuilder now = new StringBuilder();
            now.append(x).append(y);
            visit.add(before.toString()+ now);
            visit.add(now.toString()+ before);
        }
        
        return visit.size()/2;
        
    }
}