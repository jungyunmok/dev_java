package dev_java.tables;

public class DeptVO {
  private int deptNo;
  private String deptName;
  private String deptLoc;

  // 디폴트 생성자는 필요없지만 파라미터가 있는 생성자가 하나라도 선언되면
  // 제공하는 것을 원칙으로 한다
  public DeptVO() {
  }

  public DeptVO(int deptNo, String deptName, String deptLoc) {
    this.deptNo = deptNo;
    this.deptName = deptName;
    this.deptLoc = deptLoc;
  }

  public int getDeptNo() {
    return this.deptNo;
  }

  public void setDeptNo(int deptNo) {
    this.deptNo = deptNo;
  }

  public String getDeptName() {
    return this.deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public String getDeptLoc() {
    return this.deptLoc;
  }

  public void setDeptLoc(String deptLoc) {
    this.deptLoc = deptLoc;
  }
}
