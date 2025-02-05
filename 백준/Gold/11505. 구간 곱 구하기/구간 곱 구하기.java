import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static int N, M, K;
    static int depth;
    static int treeSize;
    static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        depth = getDepth(N);
        treeSize = (int) Math.pow(2, depth+1);
        tree = new long[treeSize];
        int startIdx = treeSize / 2 - 1;

        Arrays.fill(tree, 1);

        for (int i = startIdx + 1; i <= startIdx + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        initTree(treeSize-1);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                updateVal(startIdx + b, c);
            }else{
                int s = startIdx + b;
                long e = startIdx + c;
                sb.append(getMul(s, (int)e)).append("\n");
            }

        }

        System.out.print(sb);
        br.close();
    }

    private static int getDepth(int n){
        int size = n;
        int depth = 0;

        while(size > 0){
            size /= 2;
            depth++;
        }

        return depth;
    }

    private static void initTree(int idx){
        while(idx > 0){
            tree[idx/2] = (tree[idx/2] * tree[idx]) % mod;
            idx--;
        }
    }

    private static long getMul(int s, int e){
        long mul = 1;

        while(s <= e){
            if(s % 2 == 1){
                mul = (mul * tree[s]) % mod;
                s++;
            }

            if(e % 2 == 0){
                mul =  (mul * tree[e]) % mod;
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return mul;
    }

    private static void updateVal(int idx, long num){
        tree[idx] = num;

        while(idx > 0){
            idx /= 2;
            tree[idx] = (tree[idx * 2] % mod)  * (tree[idx * 2 + 1] % mod) % mod;
        }

    }

}