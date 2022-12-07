package dev_java.ch03;

import java.util.Arrays;

/*
 * 배열의 단점
 * 같은 타입만 담을 수 있다.
 * 중간에 끼워넣기가 불가능하다
 * 원소의 개수가 고정되어 변경이 불가능하다
 */
public class Array2 extends Object {
  // 이른 인스턴스화(선언과 생성을 동시에)
  int i[] = new int[3]; // 0, 0, 0
  int j[] = new int[] { 1, 2, 3 }; // 1, 2, 3
  int x[] = { 1, 2, 3 }; // 1, 2, 3

  // 공부해야할 것 순서: 변수-원시배열-객체배열-자료구조(List, Map)-쿠키와 세션

  public static void main(String[] args) {
    Array2 a2 = new Array2();
    System.out.println(a2.x.toString());
    System.out.println(Arrays.toString(a2.i));
    System.out.println(Arrays.toString(a2.j));
    System.out.println(Arrays.toString(a2.x));

    for (int z = 0; z < a2.j.length; z++) {
      System.out.println(a2.j[z]);
    }

    for (int y : a2.x) {
      System.out.println(y);
    }
  } // end of main
}