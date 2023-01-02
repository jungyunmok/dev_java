package dev_java.week5.ex;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
  public void output() {
    String path = "D:\\vscode_java\\dev_java\\app\\src\\main\\java\\dev_java\\week5\\ex\\";
    FileWriter fw = null;
    try {
      fw = new FileWriter(path + "test1.txt", true);
      fw.write(97);
      fw.write(65);
    } catch (FileNotFoundException fe) {
      System.out.println("파일이 존재하지 않습니다.");
    } catch (IOException ie) {
      ie.printStackTrace();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      // 예외가 발생하든 그렇지 않든 무조건 처리할 코드는 finally에 작성
      try {
        if (fw != null) // 실행문이 하나라서 {} 생략
          // IO패키지는 스트림형태로 이동하니까 열려있을 경우 인터셉트나 위변조가 가능하므로
          // 반드시 사용 후에는 닫도록 하고있다.
          fw.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    FileTest ft = new FileTest();
    ft.output();
  }
}
