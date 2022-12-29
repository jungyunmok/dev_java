package dev_java.week5;

/*							
 * main메소드 호출은 JVM에 의해 호출된다. 							
 * JVM은 main스레드를 생성하여 main메소드를 호출한 것이다.							
 * 따라서 프로그램을 실행할 때 main메소드가 실행되었다는 것은 main스레드가 수행되는 것이다.							
 * 그리고 main안에서 사용자가 만든 새로운 스레드를 실행시켰다면 							
 * 두 개의 스레드(main 스레드와 사용자 스레드)가 작동하고 있다는 것을 의미한다.							
 * 아래 결과는 예측 불허(실행할 때마다 다를 수 있다.)							
 */
public class MainThread1_1 { // 스레드 클래스가 아님
  // 단 메인스레드는 갖고있음
  // 작동순서: 17-18-19(main start출력)-21(인스턴스화만 했음)-24(implements라서 필요)
  // -27(start()가run()호출, 즉시 실행되지 않고 대기실에서 순서를 따짐)
  // -60(run)-61-62-65(first)-66-67-70(second)-71-72

  public static void main(String[] args) {
    System.out.println("====================================");
    System.out.println("main start");
    // Runnable 인터페이스를 implements받아 start를 호출하는 방법
    Runnable r = new MyRunnableOne(); // 인터페이스 = 구현체클래스(override-추상메소드 run()) -> 다형성
    // 코드를 조금만 수정하고 유지보수가 가능함
    // 많이 손대면 손댈수록 의존관계로인해 다른 에러를 유발시킴
    Thread myThread = new Thread(r); // r은 Runnable을 implements했기에 ()에 올 수 있음
    // Thread myThread = new Thread(this); //this는 MainThread1_1 -> 스레드클래스가 아니기에 못씀!
    // 1. 스레드가 아니어서 에러 / 2. static 안에서는 this를 사용할 수 없다
    myThread.start(); // 디폴트 가중치는 5이다 -> 절대적이진 않다
    // try {
    // // 이런 메소드들을 Thread클래스가 제공함(대기, 양보, 우선)
    // myThread.sleep(5000); // 5초동안 멈춤, 슬립은 반드시 try_catch 안에 있어야 한다!
    // myThread.yield(); // 다른 스레드에 양보해줌
    // myThread.join(); // 다른 스레드가 종료될때까지 대기
    // } catch (Exception e) {
    // }

    // extends받아 나 자신이 스레드일 때 start를 호출하는 방법
    // Thread himThread = new MyRunnableTwo();
    // himThread.start(); // 디폴트 가중치는 5이다 -> 절대적이진 않다

    // 상속으로 처리하든 인터페이스로 처리하든 그에 따른 가중치는 없다
    // 누구든 먼저 선점하는 스레드가 우선권을 갖는다
    System.out.println("main end");
  }

}

// Thread가 되는 방법에는 두 가지가 있다
// 1. 상속(extends)
// 2. implements
// 공통점: 둘 다 run메소드를 가질 수 있다(재정의할 수 있다) -> 그 안에서 실행문을 처리하면 안전함
class MyRunnableTwo extends Thread {
  @Override
  public void run() {
    System.out.println("MyRunnableTwo run 호출");
  }
}

class MyRunnableOne implements Runnable {
  @Override
  public void run() {
    System.out.println("run메소드 호출 성공");
    first();
  }

  public void first() {
    System.out.println("first메소드 호출 성공");
    second();
  }

  public void second() {
    System.out.println("second메소드 호출 성공");
    System.out.println("====================================");
  }
}

/*
 * 클래스를 상속받으면 클래스간의 결합도가 높아진다 -> 재사용성 떨어짐(오작동발생)
 * 기능적인 부분의 결합도를 낮추면서 테스트도 용이하고 오작동도 방지되는 방법은
 * 인터페이스 중심의 코딩을 전개하는 것이다 -> 오버라이딩(Overriding) 필수
 */