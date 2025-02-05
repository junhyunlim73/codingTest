import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] chars = skill.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i = 1; i < chars.length; i++){
            map.put(chars[i], chars[i-1]);
        }
        
        for(String skill_tree : skill_trees){
            char[] s = skill_tree.toCharArray();
            boolean[] visited = new boolean[26];
            boolean flag = false;
            
            for(char ch : s){
                if(map.containsKey(ch)){
                    char val = map.get(ch);
                    int preIdx = val - 'A';
                    
                    if(!visited[preIdx]){
                        flag = true;
                        break;
                    }
                    
                }
                
                int idx = ch - 'A';
                visited[idx] = true;
            }
            
            if(!flag)
                answer++;
        }
        
        return answer;
    }
}