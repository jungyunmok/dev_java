package dev_java.ch02;

public class P21 {
  int i = 1;
  int j = 0;

  void methodA() {
    j = ++i;
    System.out.println("methodA j: " + j); // 2
    j = i++;
    System.out.println("methodA j: " + j); // 2
    System.out.println("methodA i: " + i); // 3
  }

  void methodB() {
    j = --i;
    System.out.println("methodB j: " + j); // 2
    j = i--;
    System.out.println("methodB j: " + j); // 2
    System.out.println("methodB i: " + i); // 1
  }

  void methodC(int i, int j) { // call by value, 지변의 값은 호출될 때 결정됨
    j = i++;
    System.out.println("methodC j: " + j);
    System.out.println("methodC i: " + i);
  }

  void methodD(int i, int j) {
    j *= i;
    System.out.println("methodD j: " + j);
    System.out.println("methodD i: " + i);
  }

  public static void main(String[] args) {
    P21 p21 = new P21();
    p21.methodA();
    p21.methodB();
    p21.methodC(1, 3);
    p21.methodD(1, 3);
  }
}