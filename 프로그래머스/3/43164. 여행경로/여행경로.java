import java.util.*;

class Solution {
    String pathAnswer="Z";
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        return pathAnswer.split(" ");
    }
    
    public void dfs(String[][] tickets, String curr, String path, int depth){
        if(depth == tickets.length){
            pathAnswer = path.compareTo(pathAnswer) <0? path : pathAnswer;
            return;
        }
        
        for(int i=0; i< tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(curr)){
                visited[i]=true;
                dfs(tickets, tickets[i][1], path+" "+ tickets[i][1] ,depth+1);
                visited[i]=false;
            }
        }
    }
}