import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1)
            System.out.println("A");
        else if(N == 2){
            if(arr[0] == arr[1])
                System.out.println(arr[0]);
            else
                System.out.println("A");
        }else{
            int x = arr[1] - arr[0];
            int y = arr[2] - arr[1];

            int a, b;

            if(x == 0){
                a = 1;
                b = 0;
            }else{
                a =  y / x;
                b = arr[1] - (arr[0] * a);
            }

            for(int i = 1; i < N; i++){
                int num = arr[i-1] * a + b;

                if(arr[i] != num){
                    System.out.println("B");
                    return;
                }
            }

            System.out.println(arr[N-1]*a + b);
        }

        br.close();
    }

}