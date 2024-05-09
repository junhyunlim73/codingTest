import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            Long num = Long.parseLong(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            Long num = Long.parseLong(st.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num) + " ");
            }else
                sb.append("0 ");
        }

        System.out.println(sb.toString());
        br.close();

    }
}