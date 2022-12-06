package dev_java.ch02;

public class P21_1 {

  public static void main(String[] args) {
    int i = 1;
    switch (i) {
      case 0:
        ++i; // 실행문
      case 1:
        ++i;
        // break; //2, break가 있다면 연산 후 switch문을 빠져나감
      default: // case의 조건이 맞지 않을 경우 디폴트값이 실행됨
        ++i; // 3, break가 없다면 전부 연산
    } // end of switch

    // insert here-i는 얼마일까요?
    System.out.println(i);// 3, break문이 없어서 빠져나가지 않고 전부 실행됨!
  }
}