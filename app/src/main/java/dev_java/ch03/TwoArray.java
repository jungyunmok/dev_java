package dev_java.ch03;

// 2차 배열 -> List<Map<>> 제네릭 -> 웹개발, 앱개발(하이브리드)-JSON
public class TwoArray {
  void toFor(int[][] arr) {
    for (int i = 0; i < arr.length; i++) { // row의 인덱스
      for (int j = 0; j < arr[i].length; j++) { // column의 인덱스
        System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
      } // end of inner for
    } // end of outter for
  }

  void toWhile(int[][] arr) {
    int i = 0;
    while (i < arr.length) {
      int j = 0;
      while (j < arr[i].length) {
        System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
        j++;
      } // end of inner while
      i++;
    } // end of outter while
  }

  public static void main(String[] args) {
    TwoArray ta1 = new TwoArray();
    int arr[][] = new int[2][3];
    ta1.toFor(arr);
    System.out.println("==========");
    ta1.toWhile(arr);
  }
}