import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] maxTrees;
    static int[] minTrees;
    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        int size = (int) (Math.ceil(Math.log(N) / Math.log(2))) + 1;
        int treeSize = 1 << size;
        maxTrees = new int[treeSize];
        minTrees = new int[treeSize];

        Arrays.fill(maxTrees, -1);
        Arrays.fill(minTrees, 1000001);

        int startIdx = treeSize / 2 - 1;

        for(int i = startIdx + 1; i <= startIdx + N; i++) {
            int value = Integer.parseInt(br.readLine());
            maxTrees[i] = value;
            minTrees[i] = value;
        }

        initMinTrees(startIdx + N);
        initMaxTrees(startIdx + N);

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) + startIdx;
            int e = Integer.parseInt(st.nextToken()) + startIdx;

            if(s == e){
                sb.append(0).append("\n");
            }else{
                int max = getMax(s, e);
                int min = getMin(s, e);
                int result = max - min;
                sb.append(result).append("\n");
            }

        }

        System.out.print(sb);
        br.close();
    }

    private static void initMinTrees(int idx) {
        while(idx > 0){
            minTrees[idx>>1] = Math.min(minTrees[idx], minTrees[idx>>1]);
            idx--;
        }
    }

    private static void initMaxTrees(int idx) {
        while(idx > 0){
            maxTrees[idx>>1] = Math.max(maxTrees[idx], maxTrees[idx>>1]);
            idx--;
        }
    }

    private static int getMin(int s, int e){
        int min = 1000001;

        while(s <= e){

            if(s % 2 == 1){
                min = Math.min(min, minTrees[s]);
                s++;
            }

            if(e % 2 == 0){
                min = Math.min(min, minTrees[e]);
                e--;
            }

            s >>= 1;
            e >>= 1;
        }

        return min;
    }

    private static int getMax(int s, int e){
        int max = 0;

        while(s <= e){

            if(s % 2 == 1){
                max = Math.max(max, maxTrees[s]);
                s++;
            }

            if(e % 2 == 0){
                max = Math.max(max, maxTrees[e]);
                e--;
            }

            s >>= 1;
            e >>= 1;
        }

        return max;
    }
    
}