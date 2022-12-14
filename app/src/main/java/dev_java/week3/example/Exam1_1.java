package dev_java.week3.example;

import java.util.Scanner;

// 접근제한자 private > friendly > protected > public
// static-변수 앞에, 메소드 앞에, 클래스 앞에
// final-변수 앞에(상수), 메소드 앞에(오버라이딩 불가), 클래스 앞에(상속 안됨, 자손 못가짐)
public class Exam1_1 {
  public static void main(String[] args) {
    double area = 0.0;
    final double PI = 3.14;
    // new 다음에 오는 클래스가 생성됨-이 때 생성자 호출됨(메소드처럼)
    Scanner s = new Scanner(System.in);
    System.out.print("첫번째 반지름을 입력하세요.");
    String user1 = s.nextLine();
    System.out.println("사용자가 입력한 첫번째 반지름: " + user1);
    System.out.print("두번째 반지름을 입력하세요.");
    String user2 = s.nextLine();
    System.out.println("사용자가 입력한 두번째 반지름: " + user2);
    int i1 = Integer.parseInt(user1); // 첫번째 반지름을 원시형 int로 저장 >int로 바꿔 연산해야하니까
    int i2 = Integer.parseInt(user2); // 두번째 반지름을 원시형 int로 저장
    area = i1 * i2 * PI; // int*int*double -> 결과는 double타입
    System.out.println("타원형의 면적은 " + area + " 입니다.");
    s.close();
  }
}