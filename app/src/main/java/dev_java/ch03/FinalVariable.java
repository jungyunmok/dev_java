package dev_java.ch03;

public class FinalVariable {
  static void methodA() {
    final double PIE = 3.14; // 상수(바뀌지 않는 수), 모두 대문자로 씀
    // PIE = 5.45; // 재정의x, final은 값 재할당이 안됨!
  }

  public static void main(String[] args) {
    FinalVariable.methodA();
  }
}
