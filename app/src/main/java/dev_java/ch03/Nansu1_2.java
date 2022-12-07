package dev_java.ch03;

import java.util.Scanner;

// 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오(기회는 3번)
// 입력받는 값은 0~9사이의 숫자
// 힌트를 높여라, 낮춰라
// 답을 맞추면 새게임 시작이 가능(초기화실전연습)
// 답을 맞추지 못했을경우 답을 볼 수 있도록한다.
public class Nansu1_2 {
  int com = -1;

  public void ranCom() {
    com = (int) (Math.random() * 10); // 10을 곱하는 이유는 구간을 늘리기 위해서(0.0~1.0 -> 0~10 ->0~9까지의 수)
  }

  // user변수때문에 변수my(전역변수) 삭제함-메소드의 파라미터로 리턴해주니까
  // 사용자가 입력한 값을 지변에 담아야하는 이유?-비교할때만 사용하고 새 게임을 할땐 새로운 입력값이 생기기때문에
  // 또 com 변수는 전변이어야 하는지?-한번 생성되면 고정되어 사용자값이 정답인지 판가름하는 기준이기때문에
  public String ranGame(int user) {
    String msg = null;
    // 정답보다 입력한 값이 작은가?
    if (com > user) {
      msg = "높여라";
    }
    // 정답보다 입력한 값이 큰가?
    else if (com < user) {
      msg = "낮춰라";
    } else if (com == user) {
      msg = "정답";
      // return msg; //if문에서 해당 메소드를 탈출할 때 return예약어 사용 가능
      // 반복문에서는 break문을 사용한다.
    }
    return msg;
  }

  public static void main(String[] args) {
    // 실행하자마자 채번하도록 코딩하시오.-생성자 활용
    // 생성자 역할-전역변수의 초기화, 부모클래스 초기화 포함-상속
    Nansu1_2 n12 = new Nansu1_2();
    // 컴퓨터가 채번한 값을 초기화하는 메소드 호출하기
    n12.ranCom(); // 새 게임을 누르면 호출->재사용성
    // 컴퓨터가 채번한 숫자를 출력하시오.
    System.out.println("컴퓨터가 채번한 숫자: " + n12.com); // 전역변수-인스턴스 변수(유지가됨)
    // Scanner를 활용하여 사용자가 입력한 값을 받으시오.
    Scanner scanner = new Scanner(System.in); // 장치로부터 듣기(소통)-매번 새로 받아옴(반복문 안에 올 것)
    int i = 1; // 회차 표시(지역변수)
    String input = null;
    String output = null;
    // 게임 기회는 3회로 제한하시오.
    while (i < 4) { // 주의사항-무한루프 방지코드를 꼭 작성할 것(break)
      System.out.println("0~9사이의 숫자를 입력하세요.");
      input = scanner.nextLine(); // 사용자가 입력한 값 받아오기-nextLine()은 반환값이 있다.
      // 알면서도 잡지 못하는 Exception -> NullPointerException
      // System.out.println(input); // null이 아닌지 확인, null이 오면
      // NumberFormatException(숫자변환x)
      int user = Integer.parseInt(input);
      output = n12.ranGame(user);
      if ("정답".equals(output)) {
        // 정답을 맞추었을 경우 축하합니다. 라고 말한 뒤
        // 새 게임 진행 여부를 물어보시오.
        System.out.println("축하합니다.");
        i = 3;
      }
      // 시도할때마다 몇번째 기회를 사용하는지 출력하시오.
      System.out.println(user + ":" + output);
      System.out.println("정답 입력 횟수가 " + (3 - i) + "번 남았습니다.");
      i++;
      // 주어진 기회를 모두 사용하거나 정답을 맞췄을 때 새 게임 묻기
      if (i == 4) {
        System.out.println("주어진 기회(또는 정답을 맞춤)를 모두 사용하였습니다.\n새 게임을 진행하시려면 Y, 종료하시려면 N을 입력해주세요");
        String newGame = scanner.nextLine();
        if ("Y".equals(newGame.toUpperCase())) { // toUpperCase() 입력값 대문자로 치환
          // 새 게임 시작-채번을 다시해야함-ranCom()호출하기
          n12.ranCom();
          System.out.println("새 게임을 시작합니다. ==>정답: " + n12.com);
          i = 1;
        } else if ("N".equals(newGame.toUpperCase())) {
          System.out.println("게임을 종료합니다.");
          System.exit(0); // JVM과의 연결고리 끊김
        }
      }
    } // end of while
    scanner.close(); // Stream, I.O, network 사용 후 반드시 닫아줘야함
  }
}