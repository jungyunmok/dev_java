package dev_java.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dev_java.util.DBConnectionMgr;
import dev_java.week4.DeptVO;

public class DeptList {
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  DBConnectionMgr dbMhr = new DBConnectionMgr();

  public List<DeptVO> getDeptList() {
    con = dbMhr.getConnection();
    String sql = "SELECT deptno, dname, loc FROM dept";
    List<DeptVO> deptList = new ArrayList<>();
    try {
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      DeptVO dVO = null;
      while (rs.next()) {
        // dVO = new DeptVO(rs.getInt("deptno"), rs.getString("dname"),
        // rs.getString("loc"));
        dVO = DeptVO.builder().deptNo(rs.getInt("deptno")).deptName(rs.getString("dname")).deptLoc(rs.getString("loc"))
            .build();
        deptList.add(dVO);
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    return deptList;
  }

  public static void main(String[] args) {
    DeptList deptList = new DeptList();
    List<DeptVO> list = null;
    list = deptList.getDeptList();
    for (int i = 0; i < list.size(); i++) {
      DeptVO rdVO = list.get(i);
      System.out.println(rdVO.getDeptNo() + ", " + rdVO.getDeptName() + ", " + rdVO.getDeptLoc());
    }
    System.out.println("====================");

    for (DeptVO rdVO : list) {
      System.out.println(rdVO.getDeptNo() + ", " + rdVO.getDeptName() + ", " + rdVO.getDeptLoc());
    }
  }
}
