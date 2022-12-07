package dev_java.week2;

// 단위테스트
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberValidCheck {
  @DisplayName("입력받은 값 유효성 체크하기")
  @ParameterizedTest
  // @ValueSource(strings = { "5", "150", "-10" })
  @ValueSource(strings = { "151", "150", "360" })
  void 정수인가(String input) {
    assertTrue(isNumber(input)); // 숫자인가
    assertTrue(자리수체크(input)); // 세자리인가
  }

  public static boolean 자리수체크(String s) {
    boolean isOk = false; // boolean의 기본값은 false
    if (s.length() == 3) { // 입력한 String의 길이가 3인 경우(3자리일때)
      isOk = true;
      return isOk;
    } else {
      return isOk;
    }
  }

  public static boolean isNumber(String s) {
    try {
      Double.parseDouble(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  } // end of isNumber
}
