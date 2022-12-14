package dev_java.week3.example;

// 메소드 이름이 같을 경우, 메소드 오버로딩을 따져야함
class RectAngle2 {
  void method(int w, int h) {
    int area = w * h;
    System.out.println("(methodA 출력)직사각형의 면적은? " + area);
  }

  int method(int w, int h, int result) {
    result = w * h;
    return result;
  }

  long method(long w, long h) { // 이름이 같으니 파타미터 개수나 타입이 달라야한다
    return w * h;
  }
}

public class RectAngle2Main {

  public static void main(String[] args) {
    RectAngle2 r2 = new RectAngle2();
    r2.method(2, 3); // 값에의한 호출, call by value
    // insert here
    long result = r2.method(2L, 3L);
    System.out.println("(Main 출력, 파라미터3개)직사각형의 면적은? " + r2.method(2, 3, 0));
    System.out.println("(Main 출력, 파라미터 2개)직사각형의 면적은? " + result);
  }
}
/*
 * 2. 메소드를 꺼낸다-사용자정의 메소드 구현(리턴타입, 파라미터, 출력위치 결정)
 */