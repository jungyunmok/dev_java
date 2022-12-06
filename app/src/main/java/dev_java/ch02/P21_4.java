package dev_java.ch02;

public class P21_4 {
  public static void main(String[] args) {
    int i = 1;
    int j = 2;
    // |가 하나올 땐 첫 조건이 true여도 뒤의 조건을 본다(비효율적)
    // if ((i == --j) | (++i <= j)) {

    // ||가 두개올 땐 첫 조건이 true이면 뒤의 조건은 보지 않는다.(하나라도 true면 true)
    if ((i == --j) || (++i <= j)) { // i1 == j1 || 뒤의 조건은 보지 않음!
      System.out.println("조건을 만족했습니다.");
    } else {
      System.out.println("조건을 만족하지 못했습니다.");
    }
    // insert here-i의 값은? j의 값은?
    System.out.println("i: " + i + ", j: " + j); // 1, 1
  }
}

// 조건을 만족했습니다.
// i: 1, j: 1