import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];

        for(int i = 0; i <= n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(num == 0)
                union(a, b);
            else if(num == 1){
                if(find(a) != find(b)){
                    sb.append("NO").append('\n');
                }else{
                    sb.append("YES").append('\n');
                }
            }
        }

        System.out.print(sb);
        br.close();
    }

    private static int find(int a){
        if(parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b)
            parents[b] = a;
        else
            parents[a] = b;
    }

}