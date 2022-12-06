package dev_java.ch02;

public class Dowhile {
  public static void main(String[] args) {
    int i = 1;
    // while문은 조건을 수렴하지 않으면 단 한번도 실행 기회가 없다.
    while (i > 3) { // 1>3 -> false(while은 조건을 먼저 따진다.)
      System.out.println("while실행문 출력");
    }
    System.out.println("whlie출력x");

    i = 1; // 굳이 i값을 1로 초기화한 것은 동일한 조건에서 테스트하기 위함임
    do { // do-while은 조건을 나중에 따진다(무조건 한 번은 실행됨)
      System.out.println("do-while실행문 출력");
    } while (i > 3);
  }
}

// whlie출력x
// do-while실행문 출력