package dev_java.ch02;

public class Suffle {
  public static void main(String[] args) {
    // i와 j의 값을 서로 바꾸기
    int i = 3;
    int j = 5;
    int temp = 0;

    temp = i; // 3
    i = j; // 5
    j = temp; // 3

    System.out.println("i: " + i + ", j: " + j);
  }
}