package dev_java.example;

class S1 {
  static int i; // 디폴트값 0, 전역변수(글로벌하게 사용 가능), static(인스턴스화 없이 사용 가능/복제본없이 원본만있음)

  static void m() {
  }
}

class S2 {
  void n() {
    S1.i = 500;
  }
}

public class StaticTest {
  public static void main(String[] args) {
    // insert here 전역변수 i를 초기화하시오.
    S1.i = 10;
    S1 s1 = new S1();
    s1.i = 100;
    System.out.println(S1.i); // 100
    System.out.println(s1.i); // 100, static이니까 복제본x
    S2 s2 = new S2();
    // 메소드 이름 뒤에 세미콜론이면 메소드 호출
    s2.n(); // n메소드 호출
    System.out.println("n() 호출 후 ==> " + S1.i); // 500
  }
}