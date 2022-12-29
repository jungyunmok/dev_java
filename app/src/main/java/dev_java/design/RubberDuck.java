package dev_java.design;

public class RubberDuck extends Duck {
  public RubberDuck() {
    quackBehavior = new Squeak();
    flyBehavior = new FlyNoWay();
  }

  @Override
  public void display() {
    System.out.println("나는 고무오리 입니다.");
  }
}
