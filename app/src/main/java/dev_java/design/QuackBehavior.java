package dev_java.design;

// 단독으로 인스턴스화 불가 -> 구현체클래스 필요함
// QuackBehavior qb = new MuteQuack();
// QuackBehavior qb = new Quack();
// QuackBehavior qb = new Squeak();
public interface QuackBehavior {
  // 메소드 선언시 추상클래스와는 다르게 abstract예약어를 생략할 수 있다
  // 인터페이스는 추상 클래스만 가질 수 있기때문에
  public abstract void quack();
}
