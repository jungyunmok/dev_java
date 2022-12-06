package dev_java.ch02;

import java.util.Random;
import java.util.Scanner;

// 문제5: 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오(기회는 5번)
// 힌트는 낮춰라, 높여라, 맞으면 축하합니다
public class Nansu2 {
  Random random = new Random();
  Scanner scanner = new Scanner(System.in);
  int com = random.nextInt(10); // int 0~9

  void methodA() {
    System.out.println("0부터 9사이의 정수를 입력하세요.");
    int i = 0;
    while (i < 5) {
      int user = scanner.nextInt();
      if (user == 10) {
        System.out.println("종료합니다.");
        scanner.close();
        System.exit(0);
      } else if (user == com) {
        System.out.println("축하합니다! 정답은 " + com + "입니다!");
        scanner.close();
        break;
      } else if (user < com) { // 정답이 입력값보다 클 때
        i++;
        System.out.println("더 높은 값입니다. 남은 시도 횟수: " + (5 - i));
      } else if (user > com) {
        i++;
        System.out.println("더 낮은 값입니다. 남은 시도 횟수: " + (5 - i));
      }
    }
    scanner.close();
  }

  public static void main(String[] args) {
    Nansu2 n2 = new Nansu2();
    n2.methodA();
  }
}