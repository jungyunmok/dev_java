package dev_java.example.ex221215;

import java.util.Random;

// ***연습문제2***
// -10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
// *출력)
// *배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
// *음수합 : -24
// *양수합 : 17
public class Exam2_221215 {
  Random random = new Random();

  void methodA() {
    int randomNum[] = new int[10];
    int sumPos = 0;
    int sumNeg = 0;
    System.out.print("랜덤 배열: ");

    // -10~10사이의 랜덤한 숫자를 randomNum[]에 넣는 for문
    for (int i = 0; i < 10; i++) {
      int randomValue = random.nextInt(21) - 10;
      randomNum[i] = randomValue;
      System.out.print(randomNum[i] + " ");

      // 음수, 양수끼리의 합계를 구하는 if문
      if (randomNum[i] > 0) {
        sumPos += randomNum[i];
      } else if (randomNum[i] < 0) {
        sumNeg += randomNum[i];
      }
    }
    System.out.println("\n양수의 합: " + sumPos);
    System.out.println("음수의 합: " + sumNeg);
  }

  public static void main(String[] args) {
    Exam2_221215 ex2 = new Exam2_221215();
    ex2.methodA();
  }
}