import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node[] trees;
    static int N, M;
    static int treeHeight;
    static int leftNodeIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        treeHeight = getDepth(N);
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        trees = new Node[treeSize];
        leftNodeIdx = treeSize / 2 - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = leftNodeIdx + 1; i <=  leftNodeIdx + N; i++) {
            trees[i] = new Node(i  - leftNodeIdx, Integer.parseInt(st.nextToken()));
        }

        setTrees(treeSize - 1);

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                updateVal(leftNodeIdx + a, b);
            }else{
                sb.append(getMin(leftNodeIdx + a, leftNodeIdx + b)).append("\n");
            }

        }

        System.out.print(sb);
        br.close();
    }

    private static void setTrees(int idx){
        while(idx > 0){
            if(trees[idx] == null){
                idx--;
                continue;
            }

            if(trees[idx/2] == null && trees[idx] != null){
                trees[idx/2] = new Node(trees[idx].idx, trees[idx].val);
            }else if(trees[idx].val < trees[idx/2].val){
                trees[idx/2] = new Node(trees[idx].idx, trees[idx].val);
            }else if((trees[idx/2].val == trees[idx].val) && (trees[idx].idx < trees[idx/2].idx)){
                trees[idx/2] = new Node(trees[idx].idx, trees[idx].val);
            }
            
            idx--;
        }
    }

    private static void updateVal(int idx, int val){
        trees[idx].val = val;
        while(idx > 0){
            idx /= 2;

            Node leftChild = trees[idx * 2];
            Node rightChild = trees[idx * 2 + 1];

            if (rightChild == null || (leftChild.val < rightChild.val) ||
                    (leftChild.val == rightChild.val && leftChild.idx < rightChild.idx)) {
                trees[idx] = new Node(leftChild.idx, leftChild.val);
            } else {
                trees[idx] = new Node(rightChild.idx, rightChild.val);
            }

        }

    }

    private static int getMin(int s, int e){
        Node min = new Node(0, Integer.MAX_VALUE);

        while(s <= e){
            if(s % 2 == 1){
                if(trees[s].val < min.val){
                    min = new Node(trees[s].idx, trees[s].val);
                }else if((trees[s].val == min.val) && (trees[s].idx < min.idx)){
                    min = new Node(trees[s].idx, trees[s].val);
                }
                s++;
            }

            if(e % 2 == 0){
                if(trees[e].val < min.val){
                    min = new Node(trees[e].idx, trees[e].val);
                }else if((trees[e].val == min.val) && (trees[e].idx < min.idx)){
                    min = new Node(trees[e].idx, trees[e].val);
                }
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return min.idx;
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

    static class Node{
        int idx, val;

        public Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }

    }
}