package dev_java.week3.example;

import java.util.Scanner;

// **연습문제1**
// 키보드로 부터 5개의 정수를 입력 받아서 배열에 저장하세요.
// 그리고 이들의 합계와 평균을 출력하는 프로그램을 작성하시오.
public class Exam1_221215_1 {
  // 배열 선언
  int users[] = new int[5]; // 0, 0, 0, 0, 0

  // 배열에 숫자 입력
  void initUsers() {
    Scanner s = new Scanner(System.in);
    for (int i = 0; i < users.length; i++) {
      System.out.print("숫자 5개를 입력해주세요. ");
      users[i] = s.nextInt();
      System.out.println(users[i]);

    }
    s.close();
  }

  // 총합 구하기
  int total() {
    int hap = 0; // 지역변수는 반드시 초기화를 해줘야한다
    for (int i = 0; i < users.length; i++) {
      hap += users[i];
    }
    return hap;
  }

  // 평균 구하기
  void average(int hap) {
    double avg = 0.0;
    avg = hap / (double) users.length;
    System.out.println("평균: " + avg);
  }

  public static void main(String[] args) {
    Exam1_221215_1 ex1 = new Exam1_221215_1();
    ex1.initUsers();
    int hap = ex1.total();
    System.out.println("총점: " + hap);
    ex1.average(hap);
  }
}