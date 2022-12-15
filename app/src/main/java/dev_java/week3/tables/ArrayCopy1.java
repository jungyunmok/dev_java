package dev_java.week3.tables;

import java.util.Arrays;

/*
 * 깊은 복사의 경우 객체의 실제값을 새로운 객체로 복사하는 것
 * 얕은 복사의 경우 객체의 주소 값만을 복사하는 것
 */
public class ArrayCopy1 {
  void shallowCopy() {
    int[] org = { 1, 2, 3 };
    int[] org_copy = org; // 얕은 복사
    org_copy[2] = 5; // 카피를 바꿨을 때 원본도 바뀜
    for (int e : org) {
      System.out.print(e + " ");
    }
    System.out.println();
    for (int e : org_copy) {
      System.out.print(e + " ");
    }
    System.out.println("\n==========");
  }

  void deepCopy() {
    int[] org = { 1, 2, 3 };
    int[] org_copy = org.clone(); // 깊은 복사
    org_copy[2] = 5; // 카피를 바꿔도 원본을 그대로
    for (int e : org) {
      System.out.print(e + " ");
    }
    System.out.println();
    for (int e : org_copy) {
      System.out.print(e + " ");
    }
    System.out.println("\n==========");
  }

  void deepCopy2() {
    int[] org = { 1, 2, 3, 4, 5 };
    int[] org_copy = Arrays.copyOf(org, 2); // 2개만 복사됨, 원본은 그대로
    org_copy[1] = 5; // 인덱스1은 5로 변경
    for (int e : org) {
      System.out.print(e + " ");
    }
    System.out.println();
    for (int e : org_copy) {
      System.out.print(e + " ");
    }
    System.out.println("\n==========");
  }

  public static void main(String[] args) {
    ArrayCopy1 ac1 = new ArrayCopy1();
    ac1.shallowCopy();
    ac1.deepCopy();
    ac1.deepCopy2();
  }
}

/*
 * 배열 복사의 두 가지
 * 얕은 복사
 * 주소값 복사, 참조하는 실제값은 같음
 * 복사된 배열이나 원본 배열이 변경될 때 서로간의 값이 같이 바뀌는 것
 * 
 * 깊은 복사
 * 실제값을 새로운 메모리 공간에 복사
 * 복사본을 바꿔도 원본은 그대로
 */