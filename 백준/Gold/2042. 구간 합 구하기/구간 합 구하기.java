import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] trees;
    static int treeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int depth = getDepth(N);
        treeSize = (int) Math.pow(2, depth + 1);
        trees = new long[treeSize];

        int startIdx = treeSize / 2;

        for(int i = startIdx; i < startIdx + N; i++) {
            trees[i] = Long.parseLong(br.readLine());
        }

        initTree(treeSize-1);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                int targetIdx = startIdx + b - 1;
                updateTree(targetIdx, c);
            }else if(a == 2){
                int s = b + startIdx - 1;
                int e = (int) (c + startIdx - 1);
                sb.append(getSum(s, e)).append("\n");
            }

        }

        System.out.print(sb);
        br.close();
    }

    private static int getDepth(int n){
        int depth = 0;
        int size = n;

        while(size != 0){
            size /= 2;
            depth++;
        }

        return depth;
    }


    private static void initTree(int idx){
        while(idx != 1){
            trees[idx/2] += trees[idx--];
        }

    }

    private static void updateTree(int idx, long num){
        long diff = num - trees[idx];

        while(idx != 0){
            trees[idx] += diff;
            idx /= 2;
        }

    }

    private static long getSum(int start, int end){
        long sum = 0;

        while(start <= end){
            if(start % 2 == 1){
                sum += trees[start];
                start++;
            }

            if(end % 2 == 0){
                sum += trees[end];
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return sum;
    }
}