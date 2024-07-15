import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    static int visit = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        divAndCon(0 , 0, N);
        System.out.println(answer);
    }

    private static void divAndCon(int x, int y, int N){
        if(N == 0){
            answer = visit;
            return;
        }

        int size = (int)Math.pow(2, N - 1);
        int dx = x + size;
        int dy = y + size;

        if(r < dx && c < dy){
            divAndCon(x, y, N - 1);
        }else if(r < dx && c >= dy){
            visit += (int)Math.pow(4, N - 1) * 1;
            divAndCon(x, dy, N - 1);
        }else if(r >= dx && c < dy){
            visit += (int)Math.pow(4, N - 1) * 2;
            divAndCon(dx, y, N - 1);
        }else if(r >= dx && c >= dy){
            visit += (int)Math.pow(4, N - 1) * 3;
            divAndCon(dx, dy, N - 1);
        }

    }
}