import java.util.*;
import java.util.regex.*;

public class Solution {

    private final List<Pattern> patterns = new ArrayList<>();
    private final Set<Set<String>> RESULTS = new HashSet<>();
    private int banCount;
    private String[] userArr;

    public int solution(String[] userId, String[] banIdArr) {
        banCount = banIdArr.length;
        userArr = userId;
        for (String ban : banIdArr) {
            ban = ban.replace("*", ".");
            patterns.add(Pattern.compile(ban));
        }
        dfs(0, new HashSet<>());
        return RESULTS.size();
    }

    private void dfs(int depth, Set<String> set) {
        if (depth == banCount) {
            if (set.size() == banCount) {
                RESULTS.add(set);
            }
            return;
        }
        Pattern pattern = patterns.get(depth);
        for (String user : userArr) {
            if (set.contains(user)){
                continue;
            }
            if (pattern.matcher(user).matches()) {
                set.add(user);
                dfs(depth + 1, new HashSet<>(set));
                set.remove(user);
            }
        }
    }
}