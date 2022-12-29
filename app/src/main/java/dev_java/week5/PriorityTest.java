package dev_java.week5;

public class PriorityTest extends Thread {
  // Field
  private String threadName; // 스래드 이름 기억용

  // Constructor
  public PriorityTest(String threadName) {
    this.threadName = threadName;
  }

  // Method
  @Override
  public void run() {
    // 스래드 이름 출력 3번 반복
    for (int i = 0; i < 3; i++) {
      // System.out.println(threadName + "가 구동됨."); //내가 정의한 이름
      System.out.println(this.getName() + "가 구동됨."); // JVM이 부여하는 이름
    }
  }

  public static void main(String[] args) {
    // 우선 순위 테스트용
    // Thread 상속받음 -> 내 생성자가 호출되면 그보다 먼저 Thread생성자가 호출됨
    Thread t1 = new PriorityTest("제일 높은 스래드");
    Thread t2 = new PriorityTest("보통 스래드");
    Thread t3 = new PriorityTest("제일 낮은 스래드");

    t1.setPriority(Thread.MAX_PRIORITY); // 10 -> 가중치, 절대적이진 않다
    t2.setPriority(Thread.NORM_PRIORITY); // 5
    t3.setPriority(Thread.MIN_PRIORITY); // 1

    t1.start();
    t2.start();
    t3.start();
  }
}