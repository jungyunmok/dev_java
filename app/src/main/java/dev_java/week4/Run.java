package dev_java.week4;

public class Run {
  public static void main(String[] args) {
    Money m = new Money(0); // 생성자 파라미터에 맞게 0을 넣어준다.
    m.setMoney(10000);
    m.pay(5000);
    m.print(); // 5000원
  }
}