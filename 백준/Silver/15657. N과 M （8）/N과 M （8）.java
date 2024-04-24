import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] sel;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sel = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        comb(0, 0);
        System.out.println(sb.toString());
        br.close();
    }

    static void comb(int idx, int depth){
        if(depth == M){
            for(int num : sel)
                sb.append(num + " ");
            sb.append("\n");
            return;
        }

        if(idx == N)
            return;

        sel[depth] = arr[idx];
        comb(idx, depth+1);
        comb(idx+1, depth);
    }
}