package dev_java.week3;

import javax.swing.JOptionPane;

public class RandomGameLogic_2 {
  RandomGameView_2 rgView = null;
  int random_value = (int) (Math.random() * 10); // 난수값의 범위를 1~9 으로 지정;
  int count = 0; // 시도 횟수 카운트

  public RandomGameLogic_2(RandomGameView_2 rgView) {
    this.rgView = rgView;
  }

  // 새로운 난수값 설정
  void newGame() {
    random_value = (int) (Math.random() * 10);
    System.out.println("답: " + random_value);
    count = 0;
  }

  void gameMethod() {
    System.out.println("답: " + random_value);
    String input = rgView.jtf_input.getText();
    rgView.jta_display.append(input + "\n");
    String[] buttons = { "새 게임", "종료" };
    count++;
    // 정답일 경우
    if (random_value == Integer.parseInt(input)) {
      int result = JOptionPane.showOptionDialog(rgView.jf, "정답입니다!", "숫자 게임 결과", JOptionPane.YES_NO_OPTION,
          JOptionPane.INFORMATION_MESSAGE, null, buttons, "종료");
      if (result == JOptionPane.CLOSED_OPTION) {
        System.exit(0);
      } else if (result == JOptionPane.YES_OPTION) {
        rgView.jta_display.setText("");
        newGame();
      } else {
        System.exit(0);
      }
    } else if (random_value > Integer.parseInt(input)) {
      rgView.jta_display.append("더 높은 값입니다." + "\n남은 시도 횟수: " + (3 - count) + "\n");
    } else if (random_value < Integer.parseInt(input)) {
      rgView.jta_display.append("더 낮은 값입니다." + "\n남은 시도 횟수: " + (3 - count) + "\n");
    }
    // 시도 횟수 초과
    if (count == 3) {
      int result = JOptionPane.showOptionDialog(rgView.jf, "시도횟수를 모두 소진했습니다!", "시도 횟수 초과", JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE, null, buttons, "종료");
      if (result == JOptionPane.CLOSED_OPTION) {
        System.exit(0);
      } else if (result == JOptionPane.YES_OPTION) {
        rgView.jta_display.setText("");
        newGame();
      } else {
        System.exit(0);
      }
    }
    rgView.jtf_input.setText("");
    System.out.println("횟수: " + (3 - count));
  }
}