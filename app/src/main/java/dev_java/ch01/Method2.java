package dev_java.ch01;

public class Method2 {
  // void일때와 반환형이 있을 때 출력하는 방법이 다르다.

  double m1(double d) {
    // return 3.5; // 상수를 반환했으니 항상 3.5만 반환된다.
    return d; // 변수를 반환했으니 변수 d의 값이 반환된다.
  }

  void m2(int i) {
    System.out.println(i);
  }

  public static void main(String[] args) {
    Method2 method2 = new Method2();
    // 메소드 내부에 출력하는 문장이 없는 경우, 외부의 메소드에서
    // 해당 메소드에서 결정된 값을 출력하려면 반환형이 필요하다.
    double result = method2.m1(1.5);
    System.out.println(result); // 1.5
    System.out.println(method2.m1(1.5));

    method2.m2(3);
    // int result2 = method2.m2(3); // void 메소드는 사용 불가, 반환할 수 없음!
    // System.out.println(method2.m2(3)); // void 메소드는 사용 불가, 반환할 수 없음!
  }
}
