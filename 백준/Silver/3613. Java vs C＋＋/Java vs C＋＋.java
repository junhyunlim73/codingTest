import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String result = "";

        if(str.equals("_")){
            System.out.println("Error!");
            return;
        }

        if(str.indexOf("_") != -1){
            boolean flag = false;

            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '_' && !flag){
                    flag = true;
                }else if(str.charAt(i) == '_' && flag){
                    result = '_' + result;
                    break;
                } else if(str.charAt(i) != '_' && flag && Character.isLowerCase(str.charAt(i))){
                    result += Character.toUpperCase(str.charAt(i));
                    flag = false;
                }else if(Character.isUpperCase(str.charAt(i))){
                    result = str.charAt(i) + result;
                    break;
                }
                else{
                    result += str.charAt(i);
                }
            }
        }else{
            for(int i = 0; i < str.length(); i++){
                if(Character.isUpperCase(str.charAt(i))){
                    result += "_" + Character.toLowerCase(str.charAt(i));
                }else{
                    result += str.charAt(i);
                }
            }
        }

        if(Character.isUpperCase(result.charAt(0)) || result.charAt(0) == '_' || str.charAt(str.length()-1) == '_'){
            System.out.println("Error!");
        } else{
            System.out.println(result);
        }
        br.close();
    }
}