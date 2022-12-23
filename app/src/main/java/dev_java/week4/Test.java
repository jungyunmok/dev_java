package dev_java.week4;

import java.util.Scanner;

public class Test {
  public void sum() {
    Scanner sc = new Scanner(System.in);

    System.out.println("1 이상의 숫자를 입력하세요");
    int num = sc.nextInt();

    int sum = 0;
    if (num > 0) { // 0이 아니라 1이상의 숫자부터 더한다
      int i = 1;
      while (i <= num) {
        sum += i;
        i++; // 무한루프를 막기위해 루프를 돌 때마다 i를 증가시킨다
      }
      System.out.println("1부터 " + num + "까지의 합은 " + sum + "입니다.");
    } else {
      System.out.println("숫자가 1 이상이 아닙니다.");
    }
    sc.close(); // 스캐너는 사용 후 닫아준다
  }
}