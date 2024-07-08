import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[] visited;
    static boolean[] visited2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int purpose;
    static int min = Integer.MAX_VALUE;
    static int[] sel;
    static int start;
    static int link;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        sel = new int[2];
        visited = new boolean[N];
        visited2 = new boolean[N];
        purpose = N / 2;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tracking(0, 0);
        System.out.println(min);
        br.close();
    }

    private static void tracking(int depth, int h) {
        if(depth == purpose){
            int[] starts = new int[purpose];
            int[] links = new int[purpose];
            int sIndex = 0;
            int lIndex = 0;
            start = 0;
            link = 0;
            for(int i = 0; i < N; i++){
                if(visited[i])
                    starts[sIndex++] = i;
                else
                    links[lIndex++] = i;
            }

            startPerm(0, starts);
            linkPerm(0, links);

            min = Math.min(min, Math.abs(start-link));
            return;
        }

        for(int i = h; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                tracking(depth + 1, i);
                visited[i] = false;
            }
        }

    }

    private static void startPerm(int depth, int[] arr){
        if(depth == 2){
            start += matrix[sel[0]][sel[1]];
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!visited2[i]){
                visited2[i] = true;
                sel[depth] = arr[i];
                startPerm(depth + 1, arr);
                visited2[i] = false;
            }
        }

    }

    private static void linkPerm(int depth, int[] arr){
        if(depth == 2){
            link += matrix[sel[0]][sel[1]];
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!visited2[i]){
                visited2[i] = true;
                sel[depth] = arr[i];
                linkPerm(depth + 1, arr);
                visited2[i] = false;
            }
        }

    }
}
