package dev_java.ch03;

public class Array1 extends Object { // 상속-확장, 재사용(오버라이딩), 재정의해서 사용

  public static void main(String[] args) {
    // 선언과 생성을 나누어 할 수 있다.
    // 이른 주입인가 혹은 게으른 주입인가
    // 게으른 인스턴스화는 선언과 생성을 분리한다.
    // 이른 인스턴스화는 선언부에 선언과 생성을 한번에(한문장으로) 작성한다.
    int i[]; // 선언
    // int j[3] = new int[3]; //선언부에 크기가 올 수 없다
    i = new int[3]; // 생성
    // 초기화는 아직 안됨(0, 0, 0, or 객체배열이라면 null, null, null)
    System.out.println(i[0]);
    int x = 3;
    boolean isOk = false;
    try { // 예외처리 try-catch
      // 문법에러(컴파일에러)는 Exception과는 상관없다-런타임에러만 예외처리!
      // 예외가 발생할 가능성이 있는 코드를 감싼다
      // System.out.println(i[isOk]); // 문법에러
      System.out.println(i[x]); // 배열 길이 초과, ArrayIndexOutOfBoundsException(예외처리없으면 동작 멈추게됨)
    } catch (ArrayIndexOutOfBoundsException e) { // 이 에러가 발생하면 출력할 것
      System.out.println("인덱스가 범위를 넘었습니다.");
    }
    System.out.println("출력");
  }
}