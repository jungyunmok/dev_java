package dev_java.week3.example;

import java.util.Scanner;

// 두 개의 정수 중에서 큰 숫자를 반환하는 max함수를 구현하세요. 두 개의 정수를 입력 받고 큰 숫자를 출력합니다.
// 출력) 정수(두 개) : 5 8 최대값 : 8
public class Exam2 {
  Scanner scanner = new Scanner(System.in);
  int result = 0;

  int max() {
    int i;
    int j;
    System.out.print("더 큰 값을 반환합니다. \n첫번째 값: ");
    i = scanner.nextInt();
    result = i;
    System.out.print("두번째 값: ");
    j = scanner.nextInt();
    if (result < j) {
      result = j;
    }
    scanner.close();
    return result;
  }

  public static void main(String[] args) {
    Exam2 ex2 = new Exam2();
    ex2.max();
    System.out.println("더 큰 값은 " + ex2.result + " 입니다.");
  }
}