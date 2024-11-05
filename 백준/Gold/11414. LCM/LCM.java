import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static long min = Long.MAX_VALUE;
    static long N = 1;
    static long A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Long> set = new HashSet<>();

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        if(A == B){
            System.out.println(1);
            return;
        }

        if(A < B)
            swap();

        for(long i = 1; i <= Math.sqrt(A-B); i++){
            if((A-B) % i == 0){
                set.add(i);
                set.add((A - B) / i);
            }
        }

        for(long d : set){
            long r = A % d;
            long s = d - r;
            long lcm = lcm(A+s, B+s);

            if(lcm < min){
                min = lcm;
                N = s;
            }else if(lcm == min){
                N = Math.min(N, d);
            }
        }

        System.out.println(N);
        br.close();
    }

    private static long gcd(long a, long b) {
        while(b > 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private static void swap(){
        long temp = A;
        A = B;
        B = temp;
    }

}