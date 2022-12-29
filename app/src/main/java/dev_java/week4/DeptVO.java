package dev_java.week4;

import lombok.Builder;
import lombok.Data;

@Data // Getter, Setter 포함되어있음
@Builder
public class DeptVO {
  int deptNo;
  String deptName;
  String deptLoc;

  // public DeptVO(int deptNo, String deptName, String deptLoc) {
  // this.deptNo = deptNo;
  // this.deptName = deptName;
  // this.deptLoc = deptLoc;
  // }
}