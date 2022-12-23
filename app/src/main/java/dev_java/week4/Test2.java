package dev_java.week4;

import java.util.Arrays;

public class Test2 {
  String[] sArr = { "사과", "딸기", "오렌지" };

  public void q2() {
    for (int i = 2; i < 10; i = i + 2) {
      System.out.println(2 + " * " + i + " = " + (2 * i));
    }
  }

  public void q3() {
    String[] sArr = { "빨강", "노랑", "파랑" };
    // 오리지널 for문
    for (int i = 0; i < sArr.length; i++) {
      System.out.print(sArr[i] + " ");
    }
    System.out.println();

    // 개선된 for문
    for (String s : sArr) {
      System.out.print(s + " ");
    }
  }

  public static void main(String[] args) {
    Test2 t2 = new Test2();
    System.out.println(Arrays.toString(t2.sArr));
    t2.q2();
    t2.q3();
  }
}