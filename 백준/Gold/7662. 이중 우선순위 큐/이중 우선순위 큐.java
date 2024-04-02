import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Long, Integer> map;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            map = new TreeMap<>(Comparator.reverseOrder());
            for(int j = 0; j < k; j++){
                String[] temp = br.readLine().split(" ");
                Long num = Long.parseLong(temp[1]);
                if(temp[0].equals("I")){
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else{
                    if(temp[1].equals("1")){
                        if(!map.isEmpty()){
                            Long fKey = map.firstKey();
                            map.put(fKey, map.getOrDefault(fKey, 0) - 1);
                            if(map.get(fKey) == 0){
                                map.remove(fKey);
                            }
                        }
                    }else{
                        if(!map.isEmpty()){
                            Long lKey = map.lastKey();
                            map.put(lKey, map.getOrDefault(lKey, 0) - 1);
                            if(map.get(lKey) == 0){
                                map.remove(lKey);
                            }
                        }
                    }
                }
            }
            if(map.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.firstKey() + " " + map.lastKey());
            }
        }
        br.close();
    }
}