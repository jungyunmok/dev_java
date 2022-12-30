package dev_java.week6;

class Sup {
  void go() {
    System.out.println("Sup go 호출");
  }

  void stop() {
    System.out.println("Sup stop 호출");
  }
}

class Sub extends Sup {
  Sub() {
    super.stop(); // 부모의 메소드
    this.stop(); // 자신의 메소드, 현재 인스턴스화(생성되어진) 객체의 메소드
  }

  @Override
  void stop() {
    System.out.println("Sub stop 호출");
  }
}

public class SuperMain {

  public static void main(String[] args) {
    Sup sup = new Sup();
    Sub sub = new Sub();
    sup.go(); // Sup go 호출
    sub.go(); // Sup go 호출, 자손 클래스는 부모 클래스의 메소드 호출 가능
    // sup.stop(); //부모 클래스는 자손 클래스의 메소드 호출 불가!
    sub.stop(); // Sub stop 호출

    sup = sub; // 객체 주소 대입
    // sup.stop(); //선언부 타입이 다르기에 사용 불가
    sub.stop(); // Sub stop 호출

    // 부모 클래스에 stop() 추가하고 자식 클래스에서 오버라이드한 경우
    sup.stop(); // 35번이 주석이면 Sup의 메소드, 주석이 아니면 Sub 메소드 호출
    // 자손 메소드가 출력될 때 부모가 가진 stop()는 은닉 메소드(shadow method)라고 함

    // this나 super 예약어는 static이 있는 메소드 영역에서 사용 불가하다(컴파일에러)
    // super.stop();
  }
}