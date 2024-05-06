import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] board = new int[N];
        int[] ju = new int[M];
        int player = 0;

        for(int i = 0; i < N; i++){
            board[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < M; i++){
            ju[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < M; i++){
            player += ju[i];

            if(player >= N - 1){
                System.out.println(i+1);
                break;
            }

            player = Math.max(0, player + board[player]);

            if(player >= N - 1){
                System.out.println(i+1);
                break;
            }
        }

        br.close();
    }
}