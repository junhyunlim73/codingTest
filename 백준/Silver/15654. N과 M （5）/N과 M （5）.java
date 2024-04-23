import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[] arr;
    static int[] sel;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        sel = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        perm(0);
        System.out.println(sb.toString());
        br.close();
    }

    static void perm(int depth){
        if(depth == M){
            for(int n : sel)
                sb.append(n + " ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = arr[i];
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}