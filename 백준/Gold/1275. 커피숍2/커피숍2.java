import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int size = getDepth(N);
        int treeSize = 1 << (size + 1);

        trees = new long[treeSize];
        int startIdx = treeSize / 2 - 1;

        st = new StringTokenizer(br.readLine());

        for(int i = startIdx + 1; i <= startIdx + N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        initTree(treeSize - 1);

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + startIdx;
            int y = Integer.parseInt(st.nextToken()) + startIdx;
            int a = Integer.parseInt(st.nextToken()) + startIdx;
            int b = Integer.parseInt(st.nextToken());

            if(x > y)
                sb.append(getSum(y, x)).append("\n");
            else
                sb.append(getSum(x, y)).append("\n");

            updateVal(a, b);
        }

        System.out.print(sb);
        br.close();
    }

    private static int getDepth(int n){
        int depth = 1;

        while((1 << depth) < n){
            depth++;
        }

        return depth;
    }

    private static void initTree(int idx){
        while(idx > 0){
            trees[idx/2] += trees[idx--];
        }
    }

    private static long getSum(int s, int e){
        long sum = 0;

        while(s <= e){
            if(s % 2 == 1){
                sum += trees[s++];
            }

            if(e % 2 == 0){
                sum += trees[e--];
            }

            s >>= 1;
            e >>= 1;
        }

        return sum;
    }

    private static void updateVal(int idx, int val){
        long diff = trees[idx] - val;
        trees[idx] = val;
        idx >>= 1;

        while(idx > 0){
            trees[idx] -= diff;
            idx >>= 1;
        }

    }

}