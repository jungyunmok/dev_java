package dev_java.week3;

import java.util.Arrays;
import java.util.Collections;

// 과목별 총점, 학생별 총점, 평균, 석차를 구하기
public class StudentArray {
  String[] subject = { "JAVA", "ORACLE", "SPRING" };
  String[][] data = {
      { "이순신", "80", "75", "70" },
      { "강감찬", "90", "85", "95" },
      { "김춘추", "65", "60", "60" }
  };
  int[] total = new int[3];
  Integer[] rank = new Integer[3];

  void subTotal() { // 각 과목의 총점
    int subTotalArr[] = new int[3];
    for (int i = 0; i < subject.length; i++) {
      for (int j = 0; j < data.length; j++) {
        subTotalArr[i] += Integer.parseInt(data[j][i + 1]);
      }
      System.out.println(subject[i] + "과목의 총점은 " + subTotalArr[i] + "입니다.");
    }
  }

  void studentTotal() { // 각 학생의 총점
    for (int i = 0; i < data.length; i++) {
      for (int j = 1; j < data[i].length; j++) {
        total[i] += Integer.parseInt(data[i][j]);
      }
      System.out.println(data[i][0] + "학생의 총점은 " + total[i] + "입니다.");
    }
  }

  void Studentavg() { // 각 학생의 평균
    for (int i = 0; i < data.length; i++) {
      System.out.println(data[i][0] + "학생의 평균은 " + (total[i] / (subject.length)) + "입니다.");
    }
  }

  void studentRank() { // 석차구하기
    for (int i = 0; i < data.length; i++) {
      rank[i] = (total[i] / (subject.length));
    }
    Arrays.sort(rank, Collections.reverseOrder());
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data.length; j++) {
        if (rank[i] == (total[j] / (subject.length))) {
          System.out.println(data[j][0] + "학생은 " + (i + 1) + "등입니다.");
        }
      }
    }
  }

  public static void main(String[] args) {
    StudentArray a4 = new StudentArray();
    a4.subTotal();
    System.out.println("=====");
    a4.studentTotal();
    System.out.println("=====");
    a4.Studentavg();
    System.out.println("=====");
    a4.studentRank();
  }
}