import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int N;
    static HashMap<Long, Integer> map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long min = Long.MAX_VALUE;
    static int count = -1;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for(int i = 0; i < N; i++){
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(long num : map.keySet()){
            if(count < map.get(num)){
                count = map.get(num);
                min = num;
            }else if(count == map.get(num)){
                min = Math.min(min, num);
            }
        }
        System.out.println(min);
        br.close();
    }
}