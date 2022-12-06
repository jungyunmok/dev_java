package dev_java.ch02;

import java.util.Scanner;

// 문제 2_1: 사용자의 입력값까지의 짝수의 합을 더하는 코드, for
public class Quiz2_1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("구하고자 하는 합의 두번째 숫자를 입력하세요.");
    int user_end = scanner.nextInt(); // 바로 int로 받아줌

    int i = 1;
    int count = 0;

    for (; i <= user_end; i++) {
      if (i % 2 == 0) { // 짝수일 경우
        count += i;
      }

    }
    System.out.printf("count: %d, i: %d %n", count, i);
    scanner.close();
  }
}
