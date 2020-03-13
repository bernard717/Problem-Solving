import java.util.*;

class Solution {
    private ArrayList<String> result = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String route = "";
        boolean[] visited = new boolean[tickets.length];

        route += "ICN";

        dfs(0, "ICN", tickets, route, visited);

        Collections.sort(result);

        String[] answer = result.get(0).split(",");

        return answer;
    }
    private void dfs(int idx, String depart, String[][] tickets, String route, boolean[] visited){
        if(idx + 1 == tickets.length + 1){
            result.add(route);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals(depart) && !visited[i]){
                route += ("," + tickets[i][1]);
                visited[i] = true;
                dfs(idx + 1, tickets[i][1], tickets, route, visited);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}
