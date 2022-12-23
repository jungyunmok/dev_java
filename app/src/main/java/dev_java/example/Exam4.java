package dev_java.example;

import java.util.Scanner;

// 두숫자를 입력 받아 둘 사이의 3의 배수 갯수를 카운트 하는 프로그램을 작성하시오.
// 예) 3, 13 두 숫자를 입력하였다면 3개 출력해 줌
public class Exam4 {
  Scanner scanner = new Scanner(System.in);

  void methodA() {
    int i;
    int j;
    int count = 0;
    System.out.println("두 숫자 사이의 3의 배수를 카운트합니다.");
    System.out.print("시작 값: ");
    i = scanner.nextInt();
    System.out.print("마지막 값: ");
    j = scanner.nextInt();

    int k = i + 1;
    for (; k < j; k++) {
      if (k % 3 == 0) {
        count++;
      }
    }
    System.out.println(i + "와 " + j + " 사이의 3의 배수는 " + count + "개 입니다.");
    scanner.close();
  }

  public static void main(String[] args) {
    Exam4 ex4 = new Exam4();
    ex4.methodA();
  }
}