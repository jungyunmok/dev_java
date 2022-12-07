package dev_java.ch03;

import java.util.Scanner;

//숫자야구게임 만들기-내가 만든 코드
public class NansuMaker {
  Scanner scanner = new Scanner(System.in);
  // 만약 여기서 채번한 값을 다른 클래스에서 재사용해야한다면
  // 멤버변수(전역변수)로 결정한다.
  int com[] = new int[3]; // 컴퓨터가 채번한 숫자
  int my[] = new int[3]; // 사용자가 입력한 숫자
  int count; // 게임 시도 횟수

  // 중복되는 숫자 없이 랜덤한 세자리 수를 생성하는 메소드
  public void ranCom() {
    com[0] = (int) (Math.random() * 10);
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]);
    do {
      com[2] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
  }

  // 유저의 입력값을 my[]에 int로 입력하는 메소드
  public void userInput() {
    System.out.println("중복되지 않는 세자리 수를 입력해주세요.");
    int user_input = scanner.nextInt();
    my[0] = user_input / 100;
    my[1] = user_input % 100 / 10;
    my[2] = user_input % 10;
  }

  // my[]와 com[]을 비교해 strike, ball, count를 출력하는 메소드
  public void baseballGame() {
    userInput();
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < my.length; i++) {
      for (int j = 0; j < com.length; j++) {
        if (my[i] == com[j]) {
          if (i == j) {
            strike++;
          } else {
            ball++;
          }
        }
      }
    }
    count++;
    System.out.println(strike + "스트라이크, " + ball + "볼 - 남은 시도 횟수: " + (5 - count));

    if (strike == my.length) {
      System.out.println("축하합니다! 정답은 " + com[0] + com[1] + com[2] + "입니다.");
      System.exit(0);
    } else if (count == 5) {
      System.out.println("시도 횟수 초과로 게임을 종료합니다.");
      System.exit(0);
    } else {
      baseballGame();
    }
  }

  public static void main(String[] args) {
    NansuMaker nansuMaker = new NansuMaker();
    nansuMaker.ranCom();
    System.out.println("ranCom값: " + nansuMaker.com[0] + nansuMaker.com[1] + nansuMaker.com[2]);
    nansuMaker.baseballGame();
  }
}
