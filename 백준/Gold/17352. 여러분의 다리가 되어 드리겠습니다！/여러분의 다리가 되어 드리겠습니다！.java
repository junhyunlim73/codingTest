import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int num = find(1);
        sb.append(num).append(" ");

        for(int i = 2; i <= N; i++) {
            find(i);
        }

        for(int i = 2; i < N + 1; i++) {
            if(parents[i] != num) {
                sb.append(parents[i]);
                break;
            }
        }

        System.out.println(sb);
    }

    private static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b){
            parents[b] = a;
        }else{
            parents[a] = b;
        }
    }

}