package dev_java.ch03;

import java.util.Scanner;

public class Test1_2 {
  public void count() {
    System.out.println("count호출"); // 로그에 출력할 값
    Scanner s = new Scanner(System.in);
    boolean isOk = false;
    while (!isOk) { // !를 붙여서 false인 isOk를 true로 만듦
      System.out.print("문자열을 입력해주세요. : ");
      String str = s.nextLine(); // nextline은 한 줄을 다 읽어옴, next는 공백 전 글자만 읽어옴
      if ("exit".equals(str)) { // 상수를 .equals 앞에둔다!(null값이와도 에러없이 작동하기위해서)
        break; // if문에서 break를 써도 while문 탈출
      } else {
        System.out.println(str.length() + "글자 입니다."); // length()는 문자열 길이를 반환
      }
    } // end of while
    s.close();
    System.out.println("프로그램을 종료합니다.");
  } // end of count

  public static void main(String[] args) {
    Test1_2 t1 = new Test1_2();
    t1.count();
  }
}