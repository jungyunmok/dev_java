package dev_java.design;

// 추상 클래스
// 단독으로 인스턴스화 할 수 없다. 반드시 구현체 클래스가 있어야한다(메소드 오버라이딩)
// 인터페이스가 추상클래스보다 더 추상적이다 -> 추상클래스는 생성자, 일반메소드 가질 수 있음
// 생성자는 전역변수의 디폴트값을 결정할 수 있으니까, 추상클래스가 덜 추상적이다
public abstract class Duck {
  FlyBehavior flyBehavior; // 인터페이스 -> 날다, 날지 못한다
  QuackBehavior quackBehavior; // 인터페이스 -> 무음 MuteQuack, 삐익 Squeak, 꽥꽥 Quack

  public Duck() { // 생성자
  }

  public abstract void display();

  public void performFly() {
    // FlyWithWings.java, FlyNoWay.java -> 구현체클래스
    flyBehavior.fly(); // 추상메소드이다 -> Override가 필요(구현체클래스가 필요함)
  }

  public void performQuack() {
    quackBehavior.quack();
  }

  public void swimming() {
    System.out.println("모든 오리는 물위에 뜬다");
  }
}