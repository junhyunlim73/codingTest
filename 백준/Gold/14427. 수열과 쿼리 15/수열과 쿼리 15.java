import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] trees;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());

        int depth = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = 1 << (depth + 1);
        trees = new int[treeSize][2];
        int startIdx = treeSize / 2 - 1;

        for (int i = 1; i < treeSize; i++) {
            Arrays.fill(trees[i], Integer.MAX_VALUE);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int idx = startIdx+i;
            trees[idx][0] = i;
            trees[idx][1] = Integer.parseInt(st.nextToken());
        }

        initTree(startIdx + N);

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                updateValue(b + startIdx, c);
            }else{
                sb.append(trees[1][0]).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    private static void initTree(int idx){
        while(idx > 0){
            int target = idx >> 1;

            if(trees[idx][1] < trees[target][1]){
               trees[target][0] = trees[idx][0];
                trees[target][1] = trees[idx][1];
            }else if((trees[target][1] == trees[idx][1]) && (trees[idx][0] < trees[target][0])){
                trees[target][0] = trees[idx][0];
            }

            idx--;
        }

    }

    private static void updateValue(int idx, int value){
        trees[idx][1] = value;
        idx >>= 1;

        while(idx > 0){
            int idx1 = idx << 1;
            int idx2 = (idx << 1) + 1;

            if(trees[idx1][1] < trees[idx2][1]){
                trees[idx][0] = trees[idx1][0];
                trees[idx][1] = trees[idx1][1];
            }else if(trees[idx2][1] < trees[idx1][1]){
                trees[idx][0] = trees[idx2][0];
                trees[idx][1] = trees[idx2][1];
            }else if(trees[idx2][1] == trees[idx1][1]){
                if(trees[idx1][0] < trees[idx2][0]){
                    trees[idx][0] = trees[idx1][0];
                    trees[idx][1] = trees[idx1][1];
                }else if(trees[idx2][0] < trees[idx1][0]){
                    trees[idx][0] = trees[idx2][0];
                    trees[idx][1] = trees[idx2][1];
                }
            }

            idx >>= 1;
        }

    }

}