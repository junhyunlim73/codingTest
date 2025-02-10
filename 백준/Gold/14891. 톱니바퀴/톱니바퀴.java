import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] tops;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tops = new String[5];

        for(int i = 1; i < 5; i++){
            tops[i] = br.readLine();
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            check(num, d);
        }

        for(int i = 1; i < 5; i++){
            if(tops[i].charAt(0) == '1'){
                total += (int) Math.pow(2, i - 1);
            }
        }

        System.out.println(total);
        br.close();
    }

    private static void check(int num, int d){
        if(num == 1){
            if(tops[1].charAt(2) != tops[2].charAt(6)){
                if(tops[2].charAt(2) != tops[3].charAt(6)){
                    if(tops[3].charAt(2) != tops[4].charAt(6)){
                        move(4, d*(-1));
                    }
                    move(3, d);
                }
                move(2, d*(-1));
            }
            move(1, d);
        }else if(num == 2){
            if(tops[1].charAt(2) != tops[2].charAt(6)){
                move(1, d*(-1));
            }

            if(tops[2].charAt(2) != tops[3].charAt(6)){
                if(tops[3].charAt(2) != tops[4].charAt(6)){
                    move(4, d);
                }
                move(3, d*(-1));
            }

            move(2, d);
        }else if(num == 3){
            if(tops[2].charAt(2) != tops[3].charAt(6)){
                if(tops[1].charAt(2) != tops[2].charAt(6)){
                    move(1, d);
                }
                move(2, d*(-1));
            }

            if(tops[3].charAt(2) != tops[4].charAt(6)){
                move(4, d*(-1));
            }
            move(3, d);
        }else{
            if(tops[3].charAt(2) != tops[4].charAt(6)){
                if(tops[2].charAt(2) != tops[3].charAt(6)){
                    if(tops[1].charAt(2) != tops[2].charAt(6)){
                        move(1, d*(-1));
                    }
                    move(2, d);
                }
                move(3, d*(-1));
            }
            move(4, d);
        }
    }

    private static void move(int num, int d){
        if(d == 1){
            String temp = tops[num].substring(7) + tops[num].substring(0, 7);
            tops[num] = temp;
        }else{
            String temp = tops[num].substring(1) +  tops[num].substring(0,1);
            tops[num] = temp;
        }
    }

}