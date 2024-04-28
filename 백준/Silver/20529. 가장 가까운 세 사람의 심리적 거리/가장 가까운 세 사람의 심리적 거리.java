import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static String[] sel;
    static String[] mbti;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int sum;
    
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        sel = new String[3];
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            mbti = new String[N];
            sum = 100000;
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(N > 32)
                sb.append(0 + "\n");
            else{
                for(int j = 0; j < N; j++)
                    mbti[j] = st.nextToken();
                combi(0, 0);
                sb.append(sum + "\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }

    static void combi(int depth, int idx){
        if(depth == 3){
            int cnt = 0;
            for(int i = 0; i < 4; i++){
                if(sum <= cnt)
                    break;
                if(sel[0].charAt(i) != sel[1].charAt(i))
                    cnt++;
                if(sel[1].charAt(i) != sel[2].charAt(i))
                    cnt++;
                if(sel[2].charAt(i) != sel[0].charAt(i))
                    cnt++;
            }
            sum = Math.min(cnt, sum);
            return;
        }

        if(idx == N)
            return;

        sel[depth] = mbti[idx];
        combi(depth+1, idx+1);
        combi(depth, idx+1);
    }
}