package dev_java.week5.ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
  File f = new File(".\test.txt");

  public void output() {
    FileWriter fw = null;
    try {
      fw = new FileWriter("test.txt", true); // true를 붙여준다
      fw.write(97);
      fw.write(65);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fw.close(); // fw를 닫아준다
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
