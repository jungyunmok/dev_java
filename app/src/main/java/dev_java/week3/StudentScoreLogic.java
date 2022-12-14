package dev_java.week3;

public class StudentScoreLogic {
  StudentScore sScore = null;

  // 셍성자
  public StudentScoreLogic(StudentScore sScore) {
    this.sScore = sScore;
  }

  public void jTable() {
    sScore.jf.add("Center", sScore.jsp);
    sScore.jf.setVisible(true);
  }

  public void newTable() {
    String newTable[][] = new String[Integer.parseInt(sScore.jtf_north.getText())][7];
    sScore.dtm.setDataVector(newTable, sScore.header);
    sScore.jtf_north.setText(""); // input에 입력된 문자열을 지우는 역할

  }

  public void sampleTable() {
    String members[][] = {
        { "홍길동", "80", "75", "85", "240", "80.0", "2" },
        { "이성계", "90", "85", "80", "255", "85.0", "1" },
        { "강감찬", "70", "75", "70", "215", "71.67", "3" }
    };
    sScore.dtm.setDataVector(members, sScore.header);
  }

  public void clearTable() {
    while (sScore.dtm.getRowCount() > 0) {
      sScore.dtm.removeRow(0);
    }
  }
}