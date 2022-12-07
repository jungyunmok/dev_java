package dev_java.ch03;

import java.util.Random;
import java.util.Scanner;

// 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오(기회는 5번)
// 입력받는 값은 0~9사이의 숫자
// 힌트를 높여라, 낮춰라
// 답을 맞추면 새게임 시작이 가능
// 답을 맞추지 못했을경우 답을 볼 수 있도록한다.
public class Nansu1_1 {
  Random random = new Random();
  Scanner scanner = new Scanner(System.in);
  int com = random.nextInt(10); // int 0~9

  void methodA() {
    System.out.println("0부터 9사이의 정수를 입력하세요. 종료하려면 10을 입력해주세요.");
    int i = 0;
    while (i < 5) {
      int user = scanner.nextInt();
      if (user == 10) { // 10을 입력하면 종료
        System.out.println("게임을 종료합니다.");
        scanner.close();
        System.exit(0);
      } else if (user == com) {
        System.out.println("축하합니다! 정답은 " + com + "입니다!");
        System.out.println("게임을 다시 시작하시려면 100, 종료하려면 그 외의 숫자를 입력해주세요.");
        user = scanner.nextInt();
        if (user == 100) { // 100은 재시작, 그 외의 숫자는 종료
          methodA();
        } else {
          System.out.println("게임을 종료합니다.");
          break;
        }
      } else if (user < com) { // 정답이 입력값보다 클 때
        i++;
        System.out.println("더 높은 값입니다. 남은 시도 횟수: " + (5 - i));
      } else if (user > com) { // 정답이 입력값보다 작을 때
        i++;
        System.out.println("더 낮은 값입니다. 남은 시도 횟수: " + (5 - i));
      }
    }
    System.out.println("시도 횟수가 모두 소진되었습니다. 게임을 종료합니다.");
    scanner.close();
  }

  public static void main(String[] args) {
    Nansu1_1 n = new Nansu1_1();
    n.methodA();
  }
}