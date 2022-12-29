package dev_java.week5;

class Sup {
  Sup() { // 부모 디폴트 생성자 선언
  }

  public void m() {
    System.out.println("Sup m() 호출");
  }
}

class Sub extends Sup {
  Sub() { // 자손 디폴트 생성자 선언
    super.m();
  }

  @Override
  public void m() {
    System.out.println("Sub m() 호출");
  }
}

public class SupNSubMain {
  public static void main(String[] args) {
    Sup sup = new Sup();
    sup.m(); // Sup m() 호출

    Sub sub = new Sub();
    sub.m(); // Sup m(), Sub m() 호출

    // 선언부(Sup) = 생성부(Sub)
    Sup sup2 = new Sub();
    // sup2.m(); // Sub m() 호출 -> 자식의 오버라이드된 메소드만 호출(생성자에 super없을경우)
    // 부모의 메소드는 shadow메소드(은닉)

    // 아래에서 sup을 대입하는 경우, 실제 생성된 객체도 Super타입
    // 따라서 강제 형변환을 해서 문법적인 문제가 없더라도,
    // 실제로 가리키는 객체는 상위(부모) 객체이므로 에러가 발생함
    // 하지만 sup2로 하게되면 실제 생성된 객체가 자손인 Sub타입이니
    // 마찬가지로 (선언된)타입이 달라 강제형변환을 해야하지만,
    // 실제 가리키는 객체가 자손타입이므로 에러없이 실행됨

    // sub = (Sub) sup; // 강제형변환, sub = new Sup();
    // sub.m(); // ClassCastException

    sub = (Sub) sup2; // sub와 sup2의 주소번지가 같아짐
    sub.m(); // Sup sup2 = new Sub()가 Sub sup2 = new Sub()와 같이 기능하게됨
  }
}