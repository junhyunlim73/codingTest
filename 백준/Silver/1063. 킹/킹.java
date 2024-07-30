import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    static LinkedHashMap<String, Integer> com;
    static int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        com = new LinkedHashMap<>();
        com.put("R", 0);
        com.put("L", 1);
        com.put("B", 2);
        com.put("T", 3);
        com.put("RT", 4);
        com.put("LT", 5);
        com.put("RB", 6);
        com.put("LB", 7);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");
        map.put(8, "H");


        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kr = Integer.parseInt(king.substring(1)) - 1;
        int kc = king.charAt(0) - '0' - 17;
        int sr = Integer.parseInt(stone.substring(1)) - 1;
        int sc = stone.charAt(0) - '0' - 17;

        for(int i = 0; i < N; i++){
            String c = br.readLine();
            int idx = com.get(c);

            int nkr = kr + dr[idx];
            int nkc = kc + dc[idx];
            int nsr = sr + dr[idx];
            int nsc = sc + dc[idx];

            if(nkr >= 0 && nkc >= 0 && nkr < 8 && nkc < 8){
                if(nkr == sr && nkc == sc){
                    if(nsr >= 0 && nsc >= 0 && nsr < 8 && nsc < 8){
                        kr = nkr;
                        kc = nkc;
                        sr = nsr;
                        sc = nsc;
                    }
                }else{
                    kr = nkr;
                    kc = nkc;
                }
            }

        }

        sb.append(map.get(kc+1)+(kr+1)).append("\n");
        sb.append(map.get(sc+1)+(sr+1)).append("\n");
        System.out.println(sb.toString());

    }
}