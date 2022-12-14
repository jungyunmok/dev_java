package dev_java.week3;

public class StudentScoreLogic_2 {
  StudentScore_2 sScore = null;

  // 셍성자
  public StudentScoreLogic_2(StudentScore_2 sScore) {
    this.sScore = sScore;
  }

  // 테이블 세팅
  public void jTable() {
    sScore.jf.add("Center", sScore.jsp);
    sScore.jf.setVisible(true);
  }

  // 새로운 테이블 만들기
  public void newTable() {
    String newTable[][] = new String[Integer.parseInt(sScore.jtf_north.getText())][7];
    sScore.dtm.setDataVector(newTable, sScore.header);
    sScore.jtf_north.setText(""); // input에 입력된 문자열을 지우는 역할
  }

  // 총점, 평균, 석차 구하기
  public void calcTable() {
    int total[] = new int[sScore.dtm.getRowCount()];
    for (int i = 0; i < total.length; i++) {
      for (int j = 1; j <= 3; j++) {
        System.out.println(total[i]);
        total[i] += Integer.parseInt(sScore.jtb.getValueAt(i, j).toString()); // jtb? dtm?
      }
      sScore.jtb.setValueAt(total[i], i, 4);
    }

    double avg[] = new double[sScore.dtm.getRowCount()];
    for (int i = 0; i < avg.length; i++) {
      avg[i] = (total[i] / 3.0);
      sScore.jtb.setValueAt(String.format("%.2f", avg[i]), i, 5);
    }

    int rank[] = new int[sScore.dtm.getRowCount()];
    for (int i = 0; i < rank.length; i++) {
      rank[i] = 1;
      for (int j = 0; j < rank.length; j++) {
        if (avg[i] < avg[j]) {
          rank[i] += 1;
        }
      }
      sScore.jtb.setValueAt(rank[i], i, 6);
    }
  }

  // 샘플 3명 출력
  public void sampleTable() {
    String members[][] = {
        { "홍길동", "80", "75", "85", "240", "80.0", "2" },
        { "이성계", "90", "85", "80", "255", "85.0", "1" },
        { "강감찬", "70", "75", "70", "215", "71.67", "3" }
    };
    sScore.dtm.setDataVector(members, sScore.header);
  }

  // 테이블 지우기
  public void clearTable() {
    while (sScore.dtm.getRowCount() > 0) {
      sScore.dtm.removeRow(0);
    }
  }
}