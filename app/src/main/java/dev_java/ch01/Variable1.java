package dev_java.ch01;

public class Variable1 {
  static int x; // 전역변수
  // 나는 파라미터가 없는 메소드.(소통x)
  // 나는 반환형이 없다.(대답x)

  void methodA() {
    int i; // 지역변수는 초기화를 생략할 수 없다!(사용하지 않았기에 컴파일에러X)
    i = 1;
    x = i; // 전역변수x를 이용해 지역변수를 메소드 밖에서 다룰 수 있다.
    System.out.println("i: " + i);
  }

  public static void main(String[] args) {
    Variable1 variable1 = new Variable1(); // 선언이 사용보다 앞에 와야한다.
    System.out.println("x: " + variable1.x); // static 영역 안에서는 non-static 타입을 호출할 수 없다.
    variable1.methodA(); // i의값
    // System.out.println(variable1.x); // 1, 순서가 중요(i값을 대입해 x가 1)
  }
}

// x: 0
// i: 1