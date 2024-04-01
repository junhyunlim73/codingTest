import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            long num = Long.parseLong(st.nextToken());
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            long num = Long.parseLong(st.nextToken());
            if(map.get(num) != null)
                bw.write(map.get(num) + " ");
            else
                bw.write("0" + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}