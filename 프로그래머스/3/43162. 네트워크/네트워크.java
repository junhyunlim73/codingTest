import java.util.*;

class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] computers) {
        parents = new int[n+1];
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i < n + 1; i++){
            parents[i] = i;
        }
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(i == j)
                    continue;
                
                if(computers[i][j] == 1){
                    int s = find(i+1);
                    int e = find(j+1);

                    if(s != e)
                        union(s, e);
                }
                
            }
        }
        
        for(int i = 1; i < n + 1; i++){
            int p = find(i);
            set.add(p);
        }
        
        return set.size();
    }
    
    private int find(int x){
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }
    
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a < b)
            parents[b] = a;
        else
            parents[a] = b;
    }
    
}