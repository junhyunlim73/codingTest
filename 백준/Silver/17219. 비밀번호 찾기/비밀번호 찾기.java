import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String[] temps = br.readLine().split(" ");
            map.put(temps[0], temps[1]);
        }

        for(int i = 0; i < M; i++){
            String key = br.readLine();
            bw.write(map.get(key) + " \n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}