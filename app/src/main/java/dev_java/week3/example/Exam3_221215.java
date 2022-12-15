package dev_java.week3.example;

import java.util.Arrays;
import java.util.Random;

// ***연습문제3***
// 0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
//   출력하고 그 숫자의 빈도수를 계산하여 출력하시오
// 원본 : 0 1 2 3 4 5 6 7 8 9
//        2 5 6 8 7 8 9 0 1 1
//        5
//        3
//        3
//        7
//        9
//        2
//        0 4 5 6 6 7 8 8 9 9
// 숫자 : 0 1 2 3 4 5 6 7 8 9
// 개수 : 10 9 18 11 7 9 15 14 7 5 
public class Exam3_221215 {
  Random random = new Random();
  int count = 0;

  void methodA() {
    int arrNum[][] = new int[10][10]; // 100개의 수를 담을 배열
    int numCount[] = new int[10]; // 개수를 담을 배열

    // 0~9까지 랜덤한 숫자 100개 채번
    while (count < 100) {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          int randomValue = random.nextInt(10);
          arrNum[i][j] = randomValue;
          count++;

          // 채번한 숫자 카운트
          for (int k = 0; k < arrNum.length; k++) {
            if (k == arrNum[i][j]) {
              numCount[k] += 1;
            }
          }
        }
        System.out.print(Arrays.toString(arrNum[i]) + " ");
        System.out.println();
      }
      System.out.println("숫자: [0  1  2  3  4  5  6  7  8  9]");
      System.out.println("개수: " + Arrays.toString(numCount) + " ");
    }
  }

  public static void main(String[] args) {
    Exam3_221215 ex3 = new Exam3_221215();
    ex3.methodA();
  }
}