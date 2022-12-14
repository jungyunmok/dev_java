package dev_java.ch03;

public class Test3 {
  void methodA() {
    System.out.println("methodA 호출 성공");
    int[] arr = { 0, 0, 0, 0 }; // 길이4, 0 0 0 0
    for (int i = 0; i <= arr.length; i++) {
      try {
        arr[i] += (10 + i);
        System.out.println(arr[i]);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e.toString()); // index가 4가될 때 try문으로 나와서 출력됨
      } // end of try
    } // end of for
    System.out.println("methodA 종료");
  }

  public static void main(String[] args) {
    Test3 t3 = new Test3();
    t3.methodA();
  }
}
