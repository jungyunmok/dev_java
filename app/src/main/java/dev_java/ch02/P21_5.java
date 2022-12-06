package dev_java.ch02;

public class P21_5 {
  public static void main(String[] args) {
    int i = 1;
    int j = 2;
    // |가 하나올 땐 첫 조건이 true여도 뒤의 조건을 본다
    if ((i == --j) | (++i <= j)) { // i1 == j1 || i2 <= j1
      System.out.println("조건을 만족했습니다.");
    } else {
      System.out.println("조건을 만족하지 못했습니다.");
    }
    // insert here-i의 값은? j의 값은?
    System.out.println("i: " + i + ", j: " + j); // 1, 1
  }
}

// 조건을 만족했습니다.
// i: 2, j: 1