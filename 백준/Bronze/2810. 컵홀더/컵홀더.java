import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String sit = br.readLine();
        int people = 0;

        if(!sit.contains("L")){
            System.out.println(N);
            br.close();
            return;
        }

        String cupHolder = "*";

        for(int i = 0;i < N;i++){
            if(sit.charAt(i) == 'S'){
                cupHolder += "S*";
            }else if(sit.charAt(i) == 'L'){
                cupHolder += "LL*";
                i++;
            }
        }

        for(int i = 0; i < cupHolder.length();i++){
            if(cupHolder.charAt(i) == '*'){
                people++;
            }

            if(people == N){
                break;
            }
        }

        System.out.println(people);
        br.close();
    }

}