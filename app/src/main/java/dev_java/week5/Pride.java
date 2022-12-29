package dev_java.week5;

// Object클래스에는 toString()가 정의되어 있다.
// 모든 클래스는 toString()을 오버라이딩 할 수 있다.
public class Pride extends Object {
  @Override
  public String toString() {
    return "Pride자동차 입니다.";
  }

  public static void main(String[] args) {
    Pride myCar = new Pride();
    System.out.println(myCar);
    System.out.println(myCar.toString());
  }
}

// 오버라이드(6~9번줄) 주석으로 막았을 경우
// dev_java.week5.Pride@24d46ca6
// dev_java.week5.Pride@24d46ca6

// 주석으로 막지 않았을 경우
// Pride자동차 입니다.
// Pride자동차 입니다.