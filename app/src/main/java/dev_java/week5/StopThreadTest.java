package dev_java.week5;

class StopThread implements Runnable {
  boolean stopped = false;

  @Override
  public void run() {
    while (!stopped) { // true
      System.out.println("Thread is alive...."); // 출력
      try {
        Thread.sleep(500); // 0.5초 후에 다시 출력
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } // end of while
    // 아래 코드는 8번과 15번 구간 중 11번에서 멈춰있을 때, 다른 스레드가 인터셉트 가능(다른스레드가 있다면-메인스레드가 있음)
    System.out.println("Thread is deaded"); //메인이 죽는것과 상관없이 호출되고 죽음
  } // end of run

  public void stop() {
    stopped = true;
  }
}

public class StopThreadTest {
  // 29(메인스레드)30--31-32(메소드호출)-35-36(객체생성)-37(스레드객체생성-파라미터36번넘김)-
  // 38(스레드대기자방에서 우선순위따짐-자기순서에 실행)-7(run콜백호출)-18(intercept가능)
  //
  public static void main(String[] args) {
    System.out.println("main start");
    StopThreadTest stt = new StopThreadTest();
    stt.process(); // 메소드관리-stack영역
    System.out.println("main end"); // 애플리케이션(앱)이 죽는다 - 메인스레드 회수(JVM이)
  }

  public void process() {
    StopThread st = new StopThread(); // 지변으로 객체생성-automatic(이 영역에서만 살고 죽음)
    Thread th = new Thread(st); // 스레드 생성(객체파라미터)
    th.start(); // run호출
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    st.stop();
  }
}