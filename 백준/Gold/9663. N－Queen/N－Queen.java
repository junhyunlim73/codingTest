import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long cnt = 0;
    static int N;
    static boolean[] visited;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        sel = new int[N];
        perm(0);
        System.out.println(cnt);
        br.close();
    }

    private static void perm(int depth){
        if(depth == N){
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(depth == 0 && !visited[i]){
                sel[depth] = i;
                visited[i] = true;
                perm(depth+1);
                visited[i] = false;
            }

            else if(depth != 0 && !visited[i]){
                boolean isOk = false;

                for(int j = 0; j < depth; j++){
                    int x = Math.abs(sel[j] - i);
                    int y = depth - j;
                    if(x == y){
                        isOk = true;
                        break;
                    }
                }
                if(!isOk){
                    sel[depth] = i;
                    visited[i] = true;
                    perm(depth+1);
                    visited[i] = false;
                }
            }
        }

    }
}