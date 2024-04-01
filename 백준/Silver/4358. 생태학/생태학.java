import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        while (true){
            String tree = br.readLine();
            if(tree == null) {
                break;
            }
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            cnt++;
        }
        if(!map.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            for(String key : map.keySet()){
                list.add(key);
            }
            Collections.sort(list);
            for(String tree : list){
                System.out.println(tree + " " + String.format("%.4f",((float)map.get(tree) / cnt * 100)));
            }
        }
        br.close();
    }
}