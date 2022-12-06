package dev_java.ch02;

import java.util.Scanner;

// 난수발생하여 3자리의 서로 다른 숫자로 된 값을 배열에 담기(3자리수 맞추기 야구숫자게임)
//힌트문: 숫자, 자리가 일치 -> 스트라이크 / 숫자만 일치 -> 볼
public class NansuMaker {
  Scanner scanner = new Scanner(System.in);
  // 만약 여기서 채번한 값을 다른 클래스에서 재사용해야한다면
  // 멤버변수(전역변수)로 결정한다.
  int com[] = new int[3]; // 컴퓨터가 채번한 숫자
  int my[] = new int[3]; // 사용자가 선택한 숫자
  int count = 0;

  public void ranCom() {
    com[0] = (int) (Math.random() * 10);
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]);
    do {
      com[2] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
  }

  // 초기화문제+스트라이크'볼 전변?지변?
  // 자리가 같다는 것을 배열의 index를 활용하시오.
  public String account(String User_input) {
    System.out.println("0~9 사이의 숫자를 입력해주세요.");
    // insert here(힌트문: 숫자, 자리가 일치 -> 스트라이크 / 숫자만 일치 -> 볼)
    return "1스트라이크, 2볼";
  }

  public static void main(String[] args) {
    NansuMaker nansuMaker = new NansuMaker();
    nansuMaker.ranCom();
  }
}
