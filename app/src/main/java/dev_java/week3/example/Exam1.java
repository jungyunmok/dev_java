package dev_java.week3.example;

import java.util.Scanner;

// 다음은 타원의 면적을 구하는 공식입니다. 작은 반지름과 큰 반지름을 입력받아서 타원의 면적을 구하세요.
// 반지름은 정수이고, pi는 3.1416입니다.
// 계산은 소수점 2자리 까지 합니다.
// 공식)  타원면적 =  pi * r1 * r2
// 출력) 반지름(2개) : 10 20
// 타원의 면적 : 628.32
public class Exam1 {
  Scanner scanner = new Scanner(System.in);
  public final double PI = 3.1416;

  void methodA() {
    int r1;
    int r2;
    double result;
    System.out.print("타원의 면적을 구합니다. \n작은 반지름 값: ");
    r1 = scanner.nextInt();
    System.out.print("큰 반지름 값: ");
    r2 = scanner.nextInt();
    result = PI * r1 * r2;
    System.out.println("타원의 면적은 " + String.format("%.2f", result) + " 입니다.");
    scanner.close();
  }

  public static void main(String[] args) {
    Exam1 ex1 = new Exam1();
    ex1.methodA();
  }
}