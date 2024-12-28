import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] prefix;
    static int max = -1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        prefix = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arr[i][j];
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                for(int k = 1; k <= N - i; k++){
                    int x1 = j;
                    int y1 = k;
                    int x2 = j+i;
                    int y2 = k+i;
                    int total = prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1];
                    max = Math.max(max, total);
                }

            }
        }

        System.out.println(max);
        br.close();
    }

}