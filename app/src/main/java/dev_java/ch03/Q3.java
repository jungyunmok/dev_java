package dev_java.ch03;

import java.util.Arrays;

public class Q3 {
  int[] arr = new int[4]; // 길이가 4인 배열의 선언과 생성(디폴트값0)

  void methodA() {
    for (int i = 0; i < arr.length; i++) { // <=를 <로 변경(i는 0~3)
      arr[i] += (10 + i);
    }
  }

  public static void main(String[] args) {
    Q3 q = new Q3();
    q.methodA();
    System.out.println(Arrays.toString(q.arr));
    // [10, 11, 12, 13]이 출력됨
  }
}