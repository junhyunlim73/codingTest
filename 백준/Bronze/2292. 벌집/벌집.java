import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 사용자로부터 방 번호를 입력받아 정수로 변환
        
        int min = 1; // 최소 이동 단계 (중앙에서 목표 방까지의 최소 거리)
        
        int sum = 1; // 현재 단계까지 포함된 방의 최대 번호 (중앙의 첫 번째 방은 1)
        
        while (true) { // 목표 방 번호가 현재 단계의 최대 방 번호보다 클 경우 계속 반복
            if (n <= sum) // 목표 방 번호가 현재까지의 최대 방 번호보다 작거나 같으면 루프 종료
                break;
            else {
                sum += min * 6; // 각 단계에서 6의 배수로 방이 추가됨 (육각형의 각 층에 속하는 방 수)
                
                min++; // 다음 단계로 이동 (1단계씩 증가)
            }
        }
        
        System.out.println(min);
        br.close();
    }

}