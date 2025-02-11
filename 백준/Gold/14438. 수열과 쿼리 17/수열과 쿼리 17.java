import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int depth = getDepth(N);
        int treeSize = (int) Math.pow(2, depth+1);

        trees = new int[treeSize];
        Arrays.fill(trees, 1_000_000_001);
        int startIdx = treeSize / 2 - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = startIdx + 1; i <= startIdx + N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        setTrees(treeSize - 1);
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                updateVal(startIdx + b, c);
            }else{
               sb.append(getMin(startIdx + b, startIdx + c)).append("\n");
            }

        }

        System.out.print(sb);
        br.close();
    }

    private static int getDepth(int n){
        int size = n;
        int depth = 0;

        while (size > 0){
            size /= 2;
            depth++;
        }

        return depth;
    }

    private static void setTrees(int idx){
        while(idx > 0){
            trees[idx/2] = Math.min(trees[idx/2], trees[idx]);
            idx--;
        }
    }

    private static void updateVal(int idx, int n){
        trees[idx] = n;
        idx /= 2;

        while(idx > 0){
            trees[idx] = Math.min(trees[idx*2 + 1], trees[idx*2]);
            idx /= 2;
        }

    }

    private static int getMin(int s, int e){
        int min = 1_000_000_001;

        while(s <= e){
            if(s % 2 == 1){
                min = Math.min(min, trees[s]);
                s++;
            }

            if(e % 2 == 0){
                min = Math.min(min, trees[e]);
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return min;
    }

}