package dev_java.pattern;

import java.util.Scanner;

public class HintPart1 {
  Scanner s = new Scanner(System.in);
  // 선언부
  // 컴퓨터가 채번한 숫자를 담을 1차배열 선언
  int com[] = new int[3];
  // 사용자가 입력한 문자열을 쪼개서 담을 1차배열 선언
  int my[] = new int[3];
  // 회차를 담을 변수 선언
  int cnt; // 초기화 생략(디폴트값 0)

  // 새 게임 버튼을 누르면 3자리의 서로 다른 숫자를 채번한다
  // 중복된 숫자를 제거하는 목적으로 do-while문을 선택함
  public void ranCom() {
    com[0] = (int) (Math.random() * 10);
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]);
    do {
      com[2] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
  }

  // 3자리 숫자를 입력받아서 힌트문을 작성해주는 메소드 구현
  public String account(String user) {
    if (user.length() != 3) {
      return "세자리 숫자만 입력하세요"; // account 메소드 탈출하기
    }
    int temp = Integer.parseInt(user); // 파라미터로 넘어온 사용자가 입력한 문자열 값을 정수형으로 변환해서 담기
    int strike = 0;
    int ball = 0;
    try {
      temp = Integer.parseInt(user);
    } catch (NumberFormatException e) {
      return "숫자만 입력하세요.";
    }
    my[0] = temp / 100; // 256/100 -> 2.56 -> int 2만 남음
    my[1] = (temp % 100) / 10; // (256%100)/10 -> 56/10 -> 5.6 -> int 5만 남음
    my[2] = temp % 10; // 256%10 -> 6

    for (int i = 0; i < com.length; i++) { // 입력받은 숫자가 com배열에 존재하는가? 네-ball / 아니요-제외
      for (int j = 0; j < com.length; j++) { // 만일 위에서 네 라면 스트라이크인지 검사 com배열의 i자리와 my배열의 j자리가 같은가?
        if (com[i] == my[j]) { // 같은 숫자가 있는지만 비교하고 자리가 달라고 참이다(해당 숫자가 있으면 ball은 확보됨)
          if (i == j) { // 43번에서 비교한 숫자의 자리가 사용자의 입력값 자리와 같은가?
            strike++; // 자리도 같다면 strike
          } else {
            ball++; // 자리는 다르다면 ball
          }
        }
      } // end of inner for문
    } // end of outter for문
    // strike 변수값이 3이면 61번(return 스, 볼)은 실행될 기회를 못 갖는다.
    if (strike == 3) {
      return "정답입니다.";
    }
    return strike + "스, " + ball + "볼";
  }

  public void game() {
    for (; cnt < 9; cnt++) {
      String input = s.nextLine();
      String output = account(input);
      System.out.println(output);
      if (output.equals("정답입니다.")) {
        System.out.println("게임을 종료합니다.");
        System.exit(0);
      }
      System.out.println("남은 시도 횟수: " + (8 - cnt));
    }
    System.out.println("시도 횟수 초과로 게임을 종료합니다.");
    s.close();
  }

  public static void main(String[] args) {
    HintPart1 hp = new HintPart1();
    hp.ranCom();
    System.out.println("컴퓨터가 채번한 값: " + hp.com[0] + hp.com[1] + hp.com[2]);
    System.out.println("중복되지 않는 세자리 숫자를 입력해주세요");
    hp.game();
  }
}
