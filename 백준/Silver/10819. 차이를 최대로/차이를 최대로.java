import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int[] sel;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        sel = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(max);
    }

    private static void perm(int depth){
        if(depth == N){
            int sum = 0;

            for(int i = 2; i <= N; i++){
                sum += Math.abs(sel[i - 2] - sel[i - 1]);
            }

            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = A[i];
                perm(depth+1);
                visited[i] = false;
            }
        }

    }
}