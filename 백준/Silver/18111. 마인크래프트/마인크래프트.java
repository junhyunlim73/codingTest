import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B;
    static int[][] area;
    static int min = 257;
    static int max = -1;
    static int time = Integer.MAX_VALUE;
    static int height = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        area = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, area[i][j]);
                max = Math.max(max, area[i][j]);
            }
        }

        for(int k = min; k <= max; k++) {
            int temp = B;
            int t_time = 0;
            boolean flag = false;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(k < area[i][j]) {
                        t_time += 2 * (area[i][j] - k);
                        temp += (area[i][j] - k);
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(k > area[i][j]) {
                        if(k - area[i][j] <= temp){
                            t_time += k - area[i][j];
                            temp -= k - area[i][j];
                        }else{
                            flag = true;
                        }
                    }
                    if(flag)
                        break;
                }
                if(flag)
                    break;
            }

            if(!flag){
                if(t_time <= time){
                    time = t_time;
                    height = k;
                }
            }

        }

        System.out.println(time + " " + height);
    }

}