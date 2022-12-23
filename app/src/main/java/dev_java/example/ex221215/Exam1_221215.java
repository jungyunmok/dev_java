package dev_java.example.ex221215;

import java.util.Arrays;
import java.util.Scanner;

// **연습문제1**
// 키보드로 부터 5개의 정수를 입력 받아서 배열에 저장하세요.
// 그리고 이들의 합계와 평균을 출력하는 프로그램을 작성하시오.
public class Exam1_221215 {
  Scanner scanner = new Scanner(System.in);

  void methodA() {
    int num[] = new int[5];
    int sum = 0;
    double avg = 0.0;
    System.out.println("숫자 5개를 입력해주세요.");

    //정수 5개를 입력받아 num[]에 넣고 합계, 평균을 계산하는 for문
    for (int i = 0; i < num.length; i++) {
      num[i] = scanner.nextInt();
      System.out.println("입력한 값: " + Arrays.toString(num));
      sum += num[i];
      avg = sum / 5.0;
    }
    scanner.close();
    System.out.println("입력한 값의 합계는 " + sum + " 입니다.");
    System.out.println("입력한 값의 평균은 " + avg + " 입니다.");
  }

  public static void main(String[] args) {
    Exam1_221215 ex1 = new Exam1_221215();
    ex1.methodA();
  }
}