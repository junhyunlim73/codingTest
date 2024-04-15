import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<String>[] list = new ArrayList[id_list.length];
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> names = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            map.put(id_list[i], 0);
            names.put(id_list[i], i);
        }
        for(int i = 0; i < id_list.length; i++){
            list[i] = new ArrayList<>();
        }
        for(String r : report){
            String[] temp = r.split(" ");
            int num = names.get(temp[0]);
            if(list[num].indexOf(temp[1]) == -1){
                map.put(temp[1], map.getOrDefault(temp[1], 0) + 1);
                list[num].add(temp[1]);
            }
        }
        for(int i = 0; i < id_list.length; i++){
            for(String name : list[i]){
                if(map.get(name) >= k)
                    answer[i] += 1;
            }
        }
        return answer;
    }
}