import java.util.*;
class Solution {
    static ArrayList<Integer>[] network;
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        network = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            network[i] = new ArrayList<>();
        }
        for(int i = 0; i < wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            network[start].add(end);
            network[end].add(start);
        }
        for(int i = 0; i < wires.length; i++){
            int s = wires[i][0];
            int e = wires[i][1];
            int idx1 = network[s].indexOf(e);
            int idx2 = network[e].indexOf(s);
            network[s].remove(idx1);
            network[e].remove(idx2);
            int cnt = DFS(s, n) - DFS(e, n);
            min = Math.min(Math.abs(cnt), min);
            network[s].add(e);
            network[e].add(s);
        }
        return min;
    }
    
    private static int DFS(int r, int n){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> track = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        stack.add(r);
        while(!stack.isEmpty()){
            int cur = stack.removeLast();
            if(!visited[cur]){
                visited[cur] = true;
                track.add(cur);
            }
            for(int d : network[cur]){
                if(!visited[d])
                    stack.addLast(d);
            }
        }
        return track.size();
    }
}