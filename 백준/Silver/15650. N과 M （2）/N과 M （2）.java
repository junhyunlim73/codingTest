import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] sel;
    static boolean[] isVisited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new int[M];
        comb(0, 0);
        System.out.println(sb.toString());
        br.close();
    }

    static void comb(int idx, int sidx){
        if(sidx == M){
            for(int i = 0; i < M; i++){
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        if(idx == N)
            return;

        sel[sidx] = idx+1;
        comb(idx+1, sidx+1);
        comb(idx+1, sidx);
    }
}