package dev_java.example.ex221215;

// ***연습문제3***
// 0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
//   출력하고 그 숫자의 빈도수를 계산하여 출력하시오
// 원본 : 0 1 2 3 4 5 6 7 8 9
//        2 5 6 8 7 8 9 0 1 1
//        5
//        3
//        3
//        7
//        9
//        2
//        0 4 5 6 6 7 8 8 9 9
// 숫자 : 0 1 2 3 4 5 6 7 8 9
// 개수 : 10 9 18 11 7 9 15 14 7 5 
public class Exam3_221215_1 {
  int counts[] = new int[10];
  int datas[] = new int[100];

  // 100개 변수 초기화
  int[] initArray(int datas[], int size) {
    int i;
    for (i = 0; i < datas.length; i++) {
      datas[i] = (int) (Math.random() * 10);
    }
    dataPrint(datas);
    return datas;
  }

  // 변수 출력
  void dataPrint(int[] datas) {
    for (int i = 0; i < datas.length; i++) {
      System.out.print(datas[i]);
      if (i % 10 == 9) {
        System.out.println();
      }
    }
  }

  // 빈도검사 배열에 들어있는 숫자를 증가시킴
  void numberCount(int[] datas) {
    int index = 0;
    for (int i = 0; i < 100; i++) {
      index = datas[i];
      counts[index]++;
    }
  }

  public static void main(String[] args) {
    Exam3_221215_1 ex3 = new Exam3_221215_1();
    ex3.initArray(ex3.datas, 100);
    ex3.numberCount(ex3.datas);
    for (int i = 0; i < ex3.counts.length; i++) {
      System.out.print(ex3.counts[i] + " ");
    }
  }
}