package dev_java.example;

import java.util.Scanner;

// 달의 중력은 지구 중력의 17%에 불과합니다. 지구에서 몸무게가 100kg인 사람은 달에 가면 17kg밖에 안됩니다.
// 당신의 몸무게는 달에서 얼마입니까? 몸무게 N은 실수이고 키보드로부터 입력받습니다.
// 출력) 지구몸무게 : 100 달 몸무게 : 17kg
public class Exam3 {
  Scanner scanner = new Scanner(System.in);
  double moonG = 0.17;

  void methodA() {
    double i;
    System.out.print("달에서의 몸무게를 구합니다.\n지구 몸무게: ");
    i = scanner.nextDouble();
    System.out.print("지구 몸무게: " + String.format("%.1f", i) + "kg, 달 몸무게: " + String.format("%.1f", (i * moonG)) + "kg");
    scanner.close();
  }

  public static void main(String[] args) {
    Exam3 ex3 = new Exam3();
    ex3.methodA();
  }
}