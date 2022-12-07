package dev_java.ch03;

public class Q54_if {
  public void testIfA() {
    if (testIfB("true")) { // "True"가 들어간다면 true로 반환
      System.out.println("true");// true이기에 6번이 실행됨
    } else {
      System.out.println("Not true");
    }
  }

  public Boolean testIfB(String str) {
    return Boolean.valueOf(str); // 입력된 String을 boolean값으로 반환해줌
  }

  public static void main(String[] args) {
    Q54_if q54 = new Q54_if();
    q54.testIfA(); // 결과는 True
  }
}