import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static int w_cnt, b_cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DAC(0, 0, N);
        System.out.println(w_cnt);
        System.out.println(b_cnt);
    }

    private static void DAC(int r, int c, int n){
        int size = n / 2;

        if(!find(r, c, n)){
            DAC(r, c, size);
            DAC(r, c+size, size);
            DAC(r+size, c, size);
            DAC(r+size, c+size, size);
        }
    }

    private static boolean find(int r, int c, int size){
        int num = arr[r][c];
        boolean flag = false;

        for(int i = r; i < r + size; i++){
            if(!flag){
                for(int j = c; j < c + size; j++){
                    if(arr[i][j] != num){
                        flag = true;
                        break;
                    }
                }
            }
        }

        if(flag){
            return false;
        }else{
            if(num == 0)
                w_cnt++;
            else{
                b_cnt++;
            }

            return true;
        }

    }
}