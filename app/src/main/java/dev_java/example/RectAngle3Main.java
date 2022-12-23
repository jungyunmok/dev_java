package dev_java.example;

class RectAngle3 {
  void area(int params[]) {
    // 어떤게 가로, 세로인지 알 수가 없다.
    // 또한 결과값이 어떤 인덱스에 저장되어 있는지 직관적이지 않다.
    params[2] = params[0] * params[1];
    System.out.println("면적은 " + params[2]);
  }
}

public class RectAngle3Main {
  public static void main(String[] args) {
    RectAngle3 r3 = new RectAngle3();
    int params[] = { 2, 3, 0 };
    r3.area(params);
  }
}
/*
 * 3. 배열로 처리
 */