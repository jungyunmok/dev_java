package dev_java.week5;

public class MySonata extends MyCar {

  MySonata() {
    System.out.println("MySonata() 호출");
  }

  @Override
  public void display() {
    System.out.println("나는 2023년형 소나타입니다.");
  }

  public static void main(String[] args) {
    // 자기자신을 호출하더라도 상속관계에 있는 클래스가 있다면 그 부모 클래스부터 호출된다
    // 오버라이딩-> 원형을 유지해야하기에 그 기준인 부모먼저 호출됨
    MySonata ms = new MySonata();
  }
}

// MyCar() 호출
// MySonata() 호출