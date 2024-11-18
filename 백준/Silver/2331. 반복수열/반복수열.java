import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    static int A, P;
    static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        map.put(A, idx++);

        int target = 0;

        while(true){
            A = s(A);

            if(map.containsKey(A)){
                target = A;
                break;
            }

            map.put(A, idx++);
        }

        System.out.println(map.get(target));
        br.close();
    }

    private static int s(int a){
        int sum = 0;

        while(a > 0){
            int r = a % 10;
            sum += Math.pow(r, P);
            a = a / 10;
        }

        return sum;
    }

}