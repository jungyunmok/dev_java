package dev_java.example;

import java.util.Scanner;

public class Exam1_2 {
  double area; // 디폴트 0.0, 전역변수는 초기화를 생략할 수 있다(생성자가 대신해줌)
  final double PI = 3.14;

  // 자바에서는 같은 이름의 메소드를 중복선언할 수 있다
  // 단 파라미터의 개수가 다르거나 또는 타입이 달라야한다(메소드 오버로딩)
  double methodA() {
    return 0.0;
  }

  // 리턴타입 결정하기 -> 메인출력-리턴타입있음, double / 메소드출력-void
  // 파라미터의 개수와 타입 선택하기
  double methodA(int i1, int i2) {
    area = i1 * i2 * PI;
    return area;
  }

  public static void main(String[] args) {
    Exam1_2 e = new Exam1_2();

    Scanner s = new Scanner(System.in);
    System.out.print("첫번째 반지름을 입력하세요. ");
    String user1 = s.nextLine();
    System.out.println("사용자가 입력한 첫번째 반지름: " + user1);
    System.out.print("두번째 반지름을 입력하세요. ");
    String user2 = s.nextLine();
    System.out.println("사용자가 입력한 두번째 반지름: " + user2);
    int i1 = Integer.parseInt(user1);
    int i2 = Integer.parseInt(user2);
    s.close();

    e.methodA(i1, i2);
    System.out.println("타원형의 면적은 " + e.area + " 입니다.");
  }
}