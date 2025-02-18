import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int depth = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int treeSize = 1 << depth;

        trees = new long[treeSize];

        int startIdx = (treeSize >> 1) - 1;

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) + startIdx;
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                updateVal(b, c);
            }else{
                sb.append(getSum(b, c + startIdx)).append("\n");
            }

        }

        System.out.print(sb);
        br.close();
    }

    private static void updateVal(int idx, int val){
        while(idx > 0){
            trees[idx] += val;
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