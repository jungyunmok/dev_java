package dev_java.ch01;

class A1 {
  static int i = 1;
}

class A2 {
  void methodA() {
    A1.i = 2;
  }
}

public class StaticExam3 {
  public static void main(String[] args) {
    A2 a2 = new A2();
    a2.methodA();
    System.out.println(A1.i); // 2
  }
}