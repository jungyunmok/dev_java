package dev_java.design;

public class WoodDuck extends Duck {
  public WoodDuck() {
    // 설계한 객체가 어떤 특성을 가지고 어떻게 활동하는지 생성자에서 결정됨
    quackBehavior = new MuteQuack();
    flyBehavior = new FlyNoWay(); // 날 수 없음
  }

  @Override
  public void display() {
    System.out.println("나는 나무오리 입니다.");
  }
}