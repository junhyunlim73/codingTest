import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N, M;
    static int[][] arr;
    static int[] purpose;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        purpose = new int[M];
        parents = new int[N+1];
        arr = new int[N+1][N+1];

        for(int i = 1; i < N + 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            parents[i] = i;
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if(i < j){
                    if(arr[i][j] == 1)
                        union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            purpose[i] = Integer.parseInt(st.nextToken());
        }

        int num = find(purpose[0]);

        for(int i = 1; i < M; i++){
            if(num != find(purpose[i])){
                flag = true;
                break;
            }
        }

        System.out.println(!flag ? "YES" : "NO");
    }

    private static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) parents[b] = a;
        else parents[a] = b;
    }

}