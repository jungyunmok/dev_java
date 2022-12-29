package dev_java.design;

public class MallardDuck extends Duck {
  public MallardDuck() {
    // 게으른 인스턴스화(ApplicationContext)
    // (<->이른 인스턴스화(BeanFactory) -> 스프링, 전자정부프레임워크에서 중요)
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings(); // 날고있음
  }

  public void display() {
    System.out.println("저는 물오리입니다.");
  }
}