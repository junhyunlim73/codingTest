import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num1 = br.readLine();
        String num2 = br.readLine();

        map = new HashMap<>();

        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        int n1 = convertToNum(num1);
        int n2 = convertToNum(num2);
        int sum = n1 + n2;
        String str = convertToString(sum);

        System.out.println(sum);
        System.out.println(str);

        br.close();
    }

    private static int convertToNum(String num) {
        int sum = 0;
        String[] arr = num.split("");
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if(i == len - 1) {
                sum += map.get(arr[i]);
            }else{
                String key = arr[i] + arr[i + 1];

                if(map.containsKey(key)){
                    sum += map.get(key);
                    i++;
                }else{
                    sum += map.get(arr[i]);
                }
            }

        }

        return sum;
    }

    private static String convertToString(int num) {
        String romeStr = "";

        int temp = num;

        while (temp > 0) {
            int p = 0;

            if(temp >= 1000){
                p = temp / 1000;
                temp = temp % 1000;
                romeStr += "M".repeat(p);
            }else if(temp >= 100){
                p = temp / 100;
                temp = temp % 100;

                if(p == 9){
                    romeStr += "CM";
                }else if(p == 4){
                    romeStr += "CD";
                }else if(p >= 5){
                    p -= 5;
                    romeStr += "D";
                    romeStr += "C".repeat(p);
                }else{
                   romeStr += "C".repeat(p);
                }
            }else if(temp >= 10){
                p = temp / 10;
                temp = temp % 10;

                if(p == 9){
                    romeStr += "XC";
                }else if(p == 4){
                    romeStr += "XL";
                }else if(p >= 5){
                    romeStr += "L";
                    p -= 5;
                    romeStr += "X".repeat(p);
                }else{
                    romeStr += "X".repeat(p);
                }

            }else{
                p = temp;

                if(p == 9){
                    romeStr += "IX";
                }else if(p == 4){
                    romeStr += "IV";
                }else if(p >= 5){
                    romeStr += "V";
                    p -= 5;
                    romeStr += "I".repeat(p);
                }else{
                    romeStr += "I".repeat(p);
                }

                temp = 0;
            }

        }

        return romeStr;
    }

}
