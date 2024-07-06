import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[] visited;
    static int[] sel;
    static int[] arr;
    static LinkedHashSet<String> set;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[N];
        sel = new int[M];
        set = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        perm(0);

        set.forEach(System.out::println);
        br.close();
    }

    private static void perm(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(sel[i] + " ");
            }

            set.add(sb.toString());
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