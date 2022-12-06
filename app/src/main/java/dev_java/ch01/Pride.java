package dev_java.ch01;

// static은 메소드 이름 앞에도 올 수 있고
// 변수명 앞에도 올 수 있다.
// static과 인스턴스화의 차이점은
public class Pride {
  // 자동차 이름
  static String carName = "2023년형 프라이드"; // static이기에 인스턴스화 없이도 호출가능
  // 자동차 색상
  String carColor = "흰색"; // static이 없기에 static이 있는 main메소드에서 호출하려면 인스턴스화를 해야한다.
  // 바퀴수를 담는 변수 선언
  int wheelNum = 4;

  // 에러에는 두 가지가 있다.
  // 문법 에러, 런타임 에러(Exception)

  public static void main(String[] args) {
    // 변수이름 앞에 static이 있으면 인스턴스화 없이도 호출이 가능하다.
    // 이 말은 같은 객체를 복제하지 않는다는 의미가 포함된다.
    System.out.println(carName);

    // 인스턴스화(Pride객체가 메모리에 상주) -> 호출이 가능한 상태
    Pride myCar = new Pride();// Pride타입의 myCar 인스턴스 변수
    System.out.println(myCar); // Pride@5e91993f
    myCar.carColor = "보라색";

    myCar = null; // 클래스, 객체들은 초기값이 null이다.(주소번지가 가리키는 객체는 사라졌지만 타입은 남아있다.)
    System.out.println(myCar); // null
    // 이 줄에서는 자동차 색상을 호출, 출력할 수 없음(null값으로 객체와의 연결이 끊어졌기에 NullPointerException 에러)

    myCar = new Pride(); // 새로운 주소번지를 갖는다
    System.out.println(myCar); // Pride@1c4af82c
    System.out.println(myCar == myCar); // True

    // myCar.carColor = "검정색";
    System.out.println(myCar.carColor); // 전역변수 carColor 호출
    myCar.carColor = "검정색";
  }
}