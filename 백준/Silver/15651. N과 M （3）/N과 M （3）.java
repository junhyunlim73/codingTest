import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] sel;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new int[M];
        perm(0);
        System.out.println(sb.toString());
        br.close();
    }

    static void perm(int depth){
        if(depth == M){
            for(int num : sel){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            sel[depth] = i+1;
            perm(depth+1);
        }
    }
}