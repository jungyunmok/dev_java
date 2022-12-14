package dev_java.week3;

public class Main_2 {
  int i = 1;

  boolean isOk[] = null; // 선언

  // 디폴트 생성자는 생략이 가능하다
  // 그러나 지금은 isOk배열의 생성을 위해서 getisOk()를 경유하도록해야
  // NullPointerException을 피할 수 있다
  public Main_2() {
    System.out.println("Main_2 디폴트 생성자 호출 성공");
    getisOK(); // 디폴트생성자에 getisOk 넣음
  }

  // 선언과 동시에 인스턴스화를 하지 않는 경우를 게으른 인스턴스화라고 한다.
  // 선언과 생성을 동시에 하지 않고 메소드를 통해서 객체 주입을 받을 수 있다.
  // 이럴 경우 메소드 안에서 if문을 통해 null체크를 할 수 있어 싱글톤 패턴으로 객체를
  // 주입받을 수 있기에 현업에서 선호하는 객체 주입 방법 중 하나이다.
  boolean[] getisOK() {
    if (isOk == null) {
      isOk = new boolean[] { true, false, true }; // 생성, 초기화
    }
    return isOk;
  }

  public static void main(String[] args) {
  }
}