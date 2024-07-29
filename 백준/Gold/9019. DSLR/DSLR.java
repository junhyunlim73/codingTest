import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] arr;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            arr = new String[10000];
            Arrays.fill(arr, "");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Commend> q = new ArrayDeque<>();
            q.add(new Commend(start, ""));

            while (!q.isEmpty()){
                Commend now = q.poll();

                if(now.idx == end)
                    break;

                int d = (now.idx * 2) % 10000;
                if(arr[d].isEmpty()){
                    arr[d] = now.com + "D";
                    q.add(new Commend(d, arr[d]));
                }

                int s = now.idx - 1 < 0 ? 9999 : now.idx - 1;
                if(arr[s].isEmpty()){
                    arr[s] = now.com + "S";
                    q.add(new Commend(s, arr[s]));
                }

                int l = (now.idx % 1000 * 10) + now.idx / 1000;
                if(arr[l].isEmpty()){
                    arr[l] = now.com + "L";
                    q.add(new Commend(l, arr[l]));
                }

                int r = (now.idx % 10) * 1000 + now.idx / 10;
                if(arr[r].isEmpty()){
                    arr[r] = now.com + "R";
                    q.add(new Commend(r, arr[r]));
                }
            }

            sb.append(arr[end]).append("\n");
        }

        System.out.print(sb);
    }

    static class Commend{
        int idx;
        String com;

        public Commend(int idx, String com){
            this.idx = idx;
            this.com = com;
        }
    }
}