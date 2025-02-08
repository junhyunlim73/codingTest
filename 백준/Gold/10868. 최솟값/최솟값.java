import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] trees;
    static int N, M;
    static int treeSize;
    static int leftNodeStartIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int height = getHeight(N);
        treeSize = (int) Math.pow(2, height + 1);
        trees = new int[treeSize];
        leftNodeStartIdx = treeSize / 2 - 1;

        Arrays.fill(trees, Integer.MAX_VALUE);

        for(int i = leftNodeStartIdx + 1; i <= leftNodeStartIdx + N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        setTrees(treeSize - 1);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + leftNodeStartIdx;
            int b = Integer.parseInt(st.nextToken()) + leftNodeStartIdx;
            sb.append(getMin(a, b)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static int getHeight(int n){
        int len = n;
        int height = 0;

        while(len > 0){
            len /= 2;
            height++;
        }

        return height;
    }

    private static void setTrees(int idx){
        while(idx > 0){
            trees[idx/2] = Math.min(trees[idx/2], trees[idx]);
            idx--;
        }
    }

    private static int getMin(int s, int e){
        int min = Integer.MAX_VALUE;

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