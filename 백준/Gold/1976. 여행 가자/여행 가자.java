import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        arr = new int[M+1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(i < j)
                    break;

                if(num == 1)
                    union(i, j);
            }
        }

        boolean flag = false;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = find(arr[1]);

        for(int i = 2; i <= M; i++){
            if(target != find(arr[i])){
                flag = true;
                break;
            }
        }

        System.out.println(!flag ? "YES" : "NO");
        br.close();
    }

    private static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }

}