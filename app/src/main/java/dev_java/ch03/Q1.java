package dev_java.ch03;

import java.util.Scanner;

public class Q1 {
  public void Count() {
    Scanner s = new Scanner(System.in);
    boolean isOk = true; // boolean 변수 추가

    while (isOk) { // 조건문에 isOk 변수를 추가
      System.out.println("문자열을 입력해주세요: ");
      String str = s.nextLine();
      if (str.equals("exit")) { // .equals()로 변경
        isOk = false; // exit할 경우 isOk가 false로 바뀌도록 추가
        s.close(); // scanner close() 추가
        break;
      } else {
        System.out.println(str.length() + "글자 입니다.");
      }
    }
    System.out.println("프로그램을 종료합니다.");
  }

  public static void main(String[] args) {
    Q1 q = new Q1();
    q.Count();
  }
}
