import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt;
    static boolean[] visited;
    static int[] sel;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        sel = new int[N];
        perm(0);
        System.out.println(cnt);
        br.close();
    }

    static void perm(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                boolean flag = true;

                visited[i] = true;
                sel[depth] = i;

                for(int j = 0; j < depth; j++) {
                    if(Math.abs(depth - j) == Math.abs(i - sel[j])){
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    perm(depth + 1);
                }

                visited[i] = false;
            }
        }

    }

}