import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] maxTrees;
    static int[] minTrees;
    static int treeHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        treeHeight = getDepth(N);
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        maxTrees = new int[treeSize];
        minTrees = new int[treeSize];

        Arrays.fill(maxTrees, -1);
        Arrays.fill(minTrees, Integer.MAX_VALUE);

        int startIdx = treeSize / 2 - 1;

        for (int i = startIdx + 1; i <= startIdx + N; i++) {
            int num = Integer.parseInt(br.readLine());
            maxTrees[i] = num;
            minTrees[i] = num;
        }

        setMaxTrees(treeSize-1);
        setMinTrees(treeSize-1);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s += startIdx;
            e += startIdx;
            sb.append(getMin(s, e)).append(" ").append(getMax(s, e)).append("\n");
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

    private static void setMaxTrees(int idx){
        while(idx > 0){
            maxTrees[idx/2] = Math.max(maxTrees[idx/2], maxTrees[idx]);
            idx--;
        }
    }

    private static void setMinTrees(int idx){
        while(idx > 0){
            minTrees[idx/2] = Math.min(minTrees[idx/2], minTrees[idx]);
            idx--;
        }
    }

    private static int getMin(int s, int e){
        int min = Integer.MAX_VALUE;

        while(s <= e){
            if(s % 2 == 1){
                min = Math.min(min, minTrees[s]);
                s++;
            }

            if(e % 2 == 0){
                min = Math.min(min, minTrees[e]);
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return min;
    }

    private static int getMax(int s, int e){
        int max = -1;

        while(s <= e){
            if(s % 2 == 1){
                max = Math.max(max, maxTrees[s]);
                s++;
            }

            if(e % 2 == 0){
                max = Math.max(max, maxTrees[e]);
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return max;
    }

}