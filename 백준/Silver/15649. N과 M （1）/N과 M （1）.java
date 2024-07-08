import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] sel;
    static boolean[] checked;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
          StringTokenizer st = new StringTokenizer(br.readLine());
          N = Integer.parseInt(st.nextToken());
          M = Integer.parseInt(st.nextToken());

          sel = new int[M];
          checked = new boolean[N+1];

          perm(0);
          System.out.println(sb);
    }

    private static void perm(int depth){
        if(depth == M){
            for(int num : sel){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!checked[i]){
                sel[depth] = i;
                checked[i] = true;
                perm(depth+1);
                checked[i] = false;
            }
        }
    }
}