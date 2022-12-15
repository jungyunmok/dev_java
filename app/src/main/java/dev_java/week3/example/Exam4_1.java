package dev_java.week3.example;

// 두숫자를 입력 받아 둘 사이의 3의 배수 갯수를 카운트 하는 프로그램을 작성하시오.
public class Exam4_1 {
  int count;

  int account(int start, int end) {
    // for (int i = start; i < end; i++) {
    for (int i = start; i < end; i = i + 3) {
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Exam4_1 ex4 = new Exam4_1();
    ex4.account(3, 13);
    System.out.println(ex4.count);
  }
}