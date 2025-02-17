import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int depth = getDepth(N);
        int treeSize = (1 << depth);
        trees = new long[treeSize];

        int startIdx = treeSize / 2 - 1;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0){
                if(b < c)
                    sb.append(getSum(b + startIdx, c + startIdx)).append("\n");
                else
                    sb.append(getSum(c + startIdx, b + startIdx)).append("\n");
            }else{
                modifyVal(b + startIdx, c);
            }

        }

        System.out.print(sb);
        br.close();
    }

    private static int getDepth(int n) {
        int depth = 1;

        while((1 << depth) < n) {
            depth++;
        }

        return (depth + 1);
    }

    private static void modifyVal(int idx, int val){
        long diff = val - trees[idx];
        trees[idx] = val;
        idx >>= 1;

        while(idx > 0){
            trees[idx] += diff;
            idx >>= 1;
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

}