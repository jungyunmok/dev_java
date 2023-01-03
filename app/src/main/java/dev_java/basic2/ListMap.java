package dev_java.basic2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dev_java.util.DBConnectionMgr;

public class ListMap {
  DBConnectionMgr dbMgr = new DBConnectionMgr();
  Connection con = null; // 오라클 서버와 연결통로 확보
  PreparedStatement pstmt = null; // 자바에서 오라클 서버로 DML 전달
  ResultSet rs = null; // 오라클 테이블에 제공되는 커서를 조작하는 함수제공

  public List<Map<String, Object>> getEmpList() {
    List<Map<String, Object>> listMap = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT empno, ename, dname ");
    sql.append("FROM emp, dept ");
    sql.append("WHERE emp.deptno = dept.deptno");
    try {
      con = dbMgr.getConnection();
      pstmt = con.prepareStatement(sql.toString());
      rs = pstmt.executeQuery();
      listMap = new ArrayList<>();
      Map<String, Object> rMap = null;
      while (rs.next()) {
        rMap = new HashMap<>();
        rMap.put("empno", rs.getInt("empno"));
        rMap.put("ename", rs.getString("ename"));
        rMap.put("dname", rs.getString("dname"));
        listMap.add(rMap);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return listMap;
  }

  public static void main(String[] args) {
    ListMap listMap = new ListMap();
    List<Map<String, Object>> list = null;
    list = listMap.getEmpList();
    // System.out.println("list: " + list);
    for (Map<String, Object> rMap : list) {
      System.out.println(rMap.get("empno") + ", " + rMap.get("ename") + ", " + rMap.get("dname"));
    }
  }
}
