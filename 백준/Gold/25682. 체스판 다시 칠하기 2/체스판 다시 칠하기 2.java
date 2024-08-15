import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] prefix;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        prefix = new int[N+1][M+1];

        int K_2 = K*K;
        int min = 4000001;

        for(int i = 1; i < N + 1; i++) {
            String[] line = br.readLine().split("");
            for(int j = 1; j < M + 1; j++) {
                if((i + j) % 2 == 0){
                    if(line[j-1].equals("B")){
                        prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
                    }else{
                        prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + 1;
                    }
                }else {
                    if(line[j-1].equals("W")){
                        prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
                    }else{
                        prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + 1;
                    }
                }
            }
        }

        for(int i = 1; i <= N - K + 1; i++) {
            for(int j = 1; j <= M - K + 1; j++) {
                int x = i + K - 1;
                int y = j + K - 1;

                int result = Math.min(prefix[x][y] - prefix[i-1][y] - prefix[x][j-1] + prefix[i-1][j-1], K_2 - (prefix[x][y] - prefix[i-1][y] - prefix[x][j-1] + prefix[i-1][j-1]));
                min = Math.min(min, result);
            }
        }

        System.out.println(min);
    }
}