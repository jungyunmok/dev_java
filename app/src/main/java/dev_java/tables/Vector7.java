package dev_java.tables;

import java.util.Vector;

public class Vector7 {
  public static void main(String[] args) {
    String depts[][] = { { "10", "개발부", "서울", "010-123-4567" },
        { "20", "인사부", "인천", "010-234-5678" },
        { "30", "총무부", "부산", "010-345-6789" }
    };
    DeptVO[] dVOS = new DeptVO[depts.length];
    Vector<DeptVO> vDepts = new Vector<>();

    DeptVO dvo = new DeptVO(10, "개발부", "서울");
    dVOS[0] = dvo;
    vDepts.add(dvo);
    dvo = new DeptVO(20, "인사부", "인천");
    dVOS[1] = dvo;
    vDepts.add(dvo);
    dvo = new DeptVO(30, "총무부", "부산");
    dVOS[2] = dvo;
    vDepts.add(dvo);
  }
}