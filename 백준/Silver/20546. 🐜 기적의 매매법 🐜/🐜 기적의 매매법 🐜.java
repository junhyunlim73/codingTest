import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        int[] ju = new int[14];
        int jun = 0;
        int seong = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 14; i++) {
            ju[i] = Integer.parseInt(st.nextToken());
        }

        int temp = cash;

        for(int i = 0; i < 14; i++) {
            if(ju[i] <= temp) {
                int j = temp / ju[i];
                jun += j;
                temp -= ju[i] * j;
            }
        }

        jun *= ju[13];
        jun += temp;

        temp = cash;

        int inc = 0;
        int dec = 0;
        boolean flag = false;
        boolean flag2 = false;

        for(int i = 1; i < 14; i++) {
            if(!flag){
                if(ju[i] < ju[i-1] && inc == 0) {
                    dec++;
                }else if(ju[i-1] < ju[i] && dec == 0) {
                    inc++;
                }else if(ju[i-1] < ju[i] && dec != 0) {
                    dec = 0;
                    inc = 1;
                }else if(ju[i] < ju[i-1] && inc != 0) {
                    dec = 1;
                    inc = 0;
                }else if(ju[i-1] == ju[i]) {
                    dec = 0;
                    inc = 0;
                }

                if(inc == 3 && seong != 0){
                    flag = true;
                    seong *= ju[i];
                    inc = 0;
                }else if(inc == 3 && seong == 0) {
                    inc = 0;
                }else if(dec == 3){
                    if(ju[i-1] <= temp) {
                        int j = temp / ju[i];
                        seong += j;
                        temp -= ju[i] * j;
                        flag2 = true;
                    }
                    dec = 0;
                }
            }

            if(flag2){
                if(ju[i-1] <= temp) {
                    int j = temp / ju[i];
                    seong += j;
                    temp -= ju[i] * j;
                }
            }

        }

        if(!flag)
            seong *= ju[13];

        seong += temp;

        if(jun == seong){
            System.out.println("SAMESAME");
        }else if(jun > seong){
            System.out.println("BNP");
        }else{
            System.out.println("TIMING");
        }

    }

}