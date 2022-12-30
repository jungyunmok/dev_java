package dev_java.week5.ex;

public class Test {
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    try {
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      System.out.println("두 수의 나눗셈 결과 : " + num1 / num2);
    } catch (ArithmeticException e) {
      System.out.println("부적절한 나눗셈을 시도하였습니다.");
    }
  }
}