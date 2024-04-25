import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] oper;
    static int[] arr;
    static String[] sel;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        oper = new String[N-1];
        sel = new String[N-1];
        visited = new boolean[N-1];
        String[] op = {"+", "-", "*", "/"};
        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            int operNum = Integer.parseInt(st.nextToken());
            for(int j = 0; j < operNum; j++){
                oper[idx++] = op[i];
            }
        }
        perm(0);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }
    static void perm(int depth){
        if(depth == N-1){
            int sum = arr[0];
            for(int i = 0; i < N-1; i++){
                if(sel[i].equals("+")){
                    sum += arr[i+1];
                }else if(sel[i].equals("-")){
                    sum -= arr[i+1];
                }else if(sel[i].equals("*")){
                    sum *= arr[i+1];
                }else if(sel[i].equals("/")){
                    sum /= arr[i+1];
                }
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < N-1; i++){
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = oper[i];
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}