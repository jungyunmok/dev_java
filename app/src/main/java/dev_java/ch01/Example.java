package dev_java.ch01;

public class Example {
  void methodA() { // 반환x
  }

  int methodB() { // 반환값(리턴타입) int
    return 2; // 상수 int
  }

  double methodC() { // 반환값(리턴타입) double
    return 2.5; // 상수 double
  }

  boolean methodD() { // 반환값(리턴타입) boolean
    return false; // 상수 boolean
  }

  boolean isView0() { // 반환값(리턴타입) boolean(bool)
    boolean bool = false;
    return bool; // 변수
  }

  boolean isView1() { // 반환값(리턴타입) boolean(bool)
    boolean bool = true;
    return bool; // 변수
  }

  String getName() { // 반환값(리턴타입) String(name)
    String name = "이순신";
    return name; // 변수
  }

  public static void main(String[] args) {
    Example ex = new Example();
    // int x = ex.methodA(); // 해당 메소드의 반환타입이 void이기에 이렇게 사용 불가!
    int y = ex.methodB();
    // System.out.println(ex.methodA()); // 해당 메소드의 반환타입이 void이기에 이렇게 사용 불가!
    System.out.println(ex.methodB());
  }
}