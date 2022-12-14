package dev_java.week3.example;

public class RectAngle1 {

  public static void main(String[] args) {
    // 변수 선언 2개-가로 길이, 세로 길이
    // 변수 선언 1개-면적 구하기
    int width = 2;
    int height = 3;
    int area = 0;
    area = width * height;
    System.out.println("직사각형의 면적은? " + area);
  }
}
/*
 * 1. 메인메소드 안에서 처리하기
 *
 * 만약 원의 면적도 구하고 싶다면?
 * 삼각형의 면적도 구하고자 한다면?
 * 사각형의 면적도 구해야 한다면?
 * 
 * 자바에서는 같은 이름의 메소드를 선언할 수 있다.
 * 메소드 오버라이딩 / 메소드 오버로딩 -> 이 2가지 규칙으로인해 중복이름 허용됨
 * 둘의 공통점은 메소드 이름이 같을때만 따진다는 것
 * 오버라이딩의 경우, 서로 상속관계에 있거나 인터페이스의 구현체 클래스인 경우에만 따진다
 * 오버로딩의 경우, 파라미터와 타입을 따진다
 */