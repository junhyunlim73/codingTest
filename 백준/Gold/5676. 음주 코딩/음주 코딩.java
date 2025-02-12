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

        while (true){
            String line = br.readLine();
            if (line == null || line.isEmpty())
                break;

            StringTokenizer st = new StringTokenizer(line);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int depth = getDepth(N);
            int treeSize = (int) Math.pow(2, depth + 1);

            trees = new int[treeSize];
            Arrays.fill(trees, 1);

            int startIdx = treeSize / 2 - 1;

            st = new StringTokenizer(br.readLine());
            for (int i = startIdx + 1; i <= startIdx + N; i++) {
                int num = Integer.parseInt(st.nextToken());
                trees[i] = Integer.compare(num, 0);
            }

            setTrees(treeSize - 1);

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(cmd == 'C'){
                    int val = Integer.compare(b, 0);
                    updateVal(startIdx + a, val);
                }else{
                    int mul = getMul(startIdx + a, startIdx + b);

                    if(mul > 0){
                        sb.append('+');
                    }else if(mul < 0){
                        sb.append('-');
                    }else{
                        sb.append('0');
                    }

                }

            }

            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static int getDepth(int N){
        int size = N;
        int depth = 0;

        while(size > 0){
            size /= 2;
            depth++;
        }

        return depth;
    }

    private static void setTrees(int idx){
        while(idx > 0){
            trees[idx/2] *= trees[idx];
            idx--;
        }
    }

    private static void updateVal(int idx, int val){
        trees[idx] = val;
        idx /= 2;

        while(idx > 0){
            trees[idx] = trees[idx * 2] * trees[idx * 2 + 1];
            idx /= 2;
        }

    }

    private static int getMul(int s, int e){
        int mul = 1;

        while (s <= e){
            if(s % 2 == 1){
                mul *= trees[s];
                s++;
            }

            if(e % 2 == 0){
                mul *= trees[e];
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return mul;
    }

}