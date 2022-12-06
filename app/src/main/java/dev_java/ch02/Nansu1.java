package dev_java.ch02;

import java.util.Random;
import java.util.Scanner;

// 문제5: 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오
// 힌트는 낮춰라, 높여라, 맞으면 축하합니다, 기회는 5번
public class Nansu1 {

  public static void main(String[] args) {
    // 랜덤하게 채번하는 메소드를 제공하는 클래스 선언 및 생성하기
    Random random = new Random(); // new 다음에 오는 이름의 객체가 로딩 -> 생성자 호출도 일어남

    // 참조형의 선언문(클래스 선언, 초기화x)은 생성자를 호출하지 않는다 -> = new 클래스이름();이 있을때만 생성자가 호출됨
    // scanner클래스를 사용하면 입력장치로 입력된 정보를 받아올 수 있다(듣기)
    // 생성자의 파라미터에 입력장치에 대한 코드가 필요함
    // System -> 내가 사용하는 컴퓨터의 장치
    // 그 뒤에 변수 in을 붙이면 입력 장치를 나타냄
    // 사용자로부터 입력받는 장치를 생성자의 파라미터에 적어준다.
    Scanner scanner = new Scanner(System.in);

    // nextInt메소드는 Scanner클래스가 소유주이다.(Scanner에 속해있는 메소드이다)
    int com = random.nextInt(10); // 0~9(10미만)
    System.out.println("정답은 ==> " + com);

    // 회차를 카운트하는 변수 선언
    int count = 1;
    boolean isOk = true;

    // 사용자에게 입력받아야하는 유효한 값의 범위를 출력하기
    System.out.println("0부터 9사이의 정수를 입력하세요.");

    while (isOk) {
      // Scanner클래스가 소유한 nextInt 메소드 호출하기
      // nextInt의 반환타입은 int
      int user = scanner.nextInt();

      if (user == 10) {
        System.out.println("게임을 종료합니다.");
        scanner.close();
        System.exit(0);
        // 사용자가 입력한 값과 컴퓨터가 채번한 값이 같은가?
      } else if (count == 5) {
        System.out.println("시도 횟수 초과로 게임을 종료합니다.");
        System.exit(0); // 파라미터에 0을 주면 JVM과의 연결고리가 끊긴다(종료, 할당 스레드 반환)
        isOk = false;
      } else if (user == com) { // 변수가 가리키는 값이 같은지를 비교(원시형 변수, 직접접근방식)
        System.out.println("축하합니다! 정답은 " + com + "입니다!");
        scanner.close(); // 사용한 Scanner의 주소번지는 반드시 닫아준다.(위변조를 막기 위해서)
        break;
      } else if (user < com) { // 정답이 입력값보다 클 때
        System.out.println("더 높은 값입니다. 남은 시도 횟수: " + (5 - count));
        count++;
      } else if (user > com) {
        System.out.println("더 낮은 값입니다. 남은 시도 횟수: " + (5 - count));
        count++;
      }
    }
    scanner.close();
  }
}