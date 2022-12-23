package dev_java.tables;

class T1 {
  int i = 1;
}

public class T1Main {
  public static void main(String[] args) {
    T1[] t1s = new T1[3];
    T1 t1 = new T1();
    t1s[0] = t1;
    System.out.println(t1); // t1생성, 주소번지@4517d9a3

    t1 = new T1();
    t1s[1] = t1;
    System.out.println(t1); // t1생성, 주소번지@372f7a8d

    t1 = new T1();
    t1s[2] = t1;
    System.out.println(t1); // t1생성, 주소번지@2f92e0f4
    System.out.println("=====");

    for (T1 t : t1s) {
      System.out.println(t + " ");
    }
  }
}