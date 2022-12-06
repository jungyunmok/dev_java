package dev_java.ch01;

class Param {
  int ival; // non-static 전역변수(초기화 생략 가능-생성자가 해준다.), 0->100->500
}

public class TestParam {
  void effectParam(Param p) { // 메소드의 파라미터 자리(괄호 안)는 지역변수, Param p선언(초기화, 생성x), p는 원본주소번지 @abcd1234
    // 아래에 p = new Param()이 있으면 결과가 달라진다.(없을땐 같은 원본주소번지 @abcd1234이기에 둘 다 500이 나온다.)
    p = new Param(); // p의 주소번지는 @abcd1235!(새로운 p객체가 생성되어 다른 주소번지가 생성됨), int의 디폴트값 0
    p.ival = 500; // ival호출할 수 있지만 주소번지필요 -> 간접참조방식, 새로운 p객체(@abcd1235) 초기화, 500 덮어쓰기
    // p = new Param(); //이곳에 재정의한다면 sun ival은 디폴트값 0이 출력됨
    System.out.println("sub ival ===> " + p.ival); // 500, 새로운 p객체(@abcd1235)
  }

  public static void main(String[] args) { // 가장 먼저 호출(실행)되는 main메소드(main쓰레드), static은 하나(복사본을 갖지않음)
    TestParam tp = new TestParam(); // tp객체(effectParam메소드)가 생성, 호출은 아직
    Param p = new Param(); // 메인메소드 안에 있기에 지역변수, new로 p객체 생성, int의 디폴트값 0
    p.ival = 100; // 초기화, 덮어쓰기해서 100
    tp.effectParam(p); // tp의 메소드 호출, p는 17줄에서 만든 객체(원본의 주소번지를 파라미터로 넘김 -> 주소번지 @abcd1234를 넘긴다)
    System.out.println("main ival ===> " + p.ival); // 100, 원본 p객체(@abcd1234)
  }
}

// sub ival ===> 500
// main ival ===> 100