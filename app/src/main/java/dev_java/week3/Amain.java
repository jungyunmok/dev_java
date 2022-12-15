package dev_java.week3;

class A {
  int i = 1;
  Amain aMain = null;

  public A(Amain aMain) {
    System.out.println("A(AMain aMain) 호출");
    this.aMain = aMain; // 주석으로 막으면 초기화x, NullPointerException
  }

  void methodB() {
    aMain.methodA();
  }
}

public class Amain {
  A a = new A(this);

  void methodA() {
    System.out.println("AMain methodA() 호출");
  }

  public static void main(String[] args) {
    Amain aMain = new Amain();
    aMain.a.methodB();
  }
}