package dev_java.ch01;

public class Method1 {
  // 파라미터 자리는 비워두거나 원시형을 쓰거나 참조형도 올 수 있다.
  // 파라미터 자리는 호출하는 곳에서 결정이 된다.
  // 파라미터 자리에 변수는 메소드가 호출될 때 결정된다.
  // 메소드 호출은 main 메소드 안에서 해야 호출된다.
  // 메소드의 파라미터 자리는 오직 선언만 가능하다.(초기화는 불가능!)
  //
  void m(int i) { // 파라미터 자리에는 사용자가 입력한 값이 담긴다. 5(호출될 때 결정'초기화됨)
    i = i + 2; // 7
    System.out.println(i + 3); // 10
  } // end of m

  void m() {
  }

  double m1(double d) {
    return 3.5;
  } // end of m1

  public static void main(String[] args) {
    // Method1 클래스안에 정의된 메소드만 호출이 가능하다.
    Method1 method1 = new Method1();
    // 자바에서는 같은 이름의 메소드를 중복선언할 수 있다.
    // 단 파라미터의 개수가 다르거나, 타입이 다를때만 가능하다.(메소드 오버로딩)
    method1.m(5); // 메소드 호출, int이기에 실수형은 적을 수 없지만 2.0까진 쓸 수 있다.
  } // end of main
}
