import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] check;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        check = new int[N];
        perm(0);
    }

    static private void perm(int depth){
        if(depth == N){
            for(int i = 0; i < N; i++){
                System.out.print(check[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i-1]){
                check[depth] = i;
                visited[i-1] = true;
                perm(depth+1);
                visited[i-1] = false;
            }
        }
    }
}