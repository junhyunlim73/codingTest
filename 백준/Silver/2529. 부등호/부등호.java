import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static String[] arr;
    static int[] sel;
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        arr = new String[K];
        sel = new int[K + 1];
        visited = new boolean[11];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            arr[i] = st.nextToken();
        }

        perm(0);
        int size = list.size();
        sb.append(list.get(size - 1)).append("\n");
        sb.append(list.get(0)).append("\n");
        System.out.println(sb);
        br.close();
    }

    private static void perm(int depth){
        if(depth == K + 1){
            boolean flag = true;
            String str = "";

            for(int i = 0; i < K; i++){
                flag = isCheck(sel[i], sel[i+1], arr[i]);

                if(!flag){
                    break;
                }
            }

            if(flag){
                for(int i = 0; i < K + 1; i++){
                    str += sel[i];
                }
                list.add(str);
            }

            return;
        }

        for(int i = 0; i < 10; i++){
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = i;
                perm(depth + 1);
                visited[i] = false;
            }
        }

    }

    private static boolean isCheck(int num1, int num2, String op){
        if(op.equals(">"))
            return num1 > num2;
        else
            return num1 < num2;
    }

}