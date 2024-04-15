import java.util.*;
class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<String>[] list = new ArrayList[id_list.length];
        HashMap<String, Integer> reports = new HashMap<>();
        HashMap<String, Integer> names = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            reports.put(id_list[i], 0);
            names.put(id_list[i], i);
            list[i] = new ArrayList<>();
        }
        for(String r : report){
            String[] temp = r.split(" ");
            int num = names.get(temp[0]);
            if(list[num].indexOf(temp[1]) == -1){
                reports.put(temp[1], reports.getOrDefault(temp[1], 0) + 1);
                list[num].add(temp[1]);
            }
        }
        for(int i = 0; i < id_list.length; i++){
            for(String name : list[i]){
                if(reports.get(name) >= k)
                    answer[i] += 1;
            }
        }
        return answer;
    }
}